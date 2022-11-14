import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

/**
 * Classe qui represente une arborescence de fichiers et dossier avec certaines
 * fonctions simples de manipulation.
 */
public class Arbre {

    private Noeud racine; // Racine de l'arborescence

    /**
     * Classe privée pour représenter les noeuds de l'arborescence. Chaque noeud
     * contient un nom, la taille du fichier, le fichier lui-même et, si c'est un
     * répertoire, une liste de ses noeuds fils.
     * 
     */
    private class Noeud {
        private String nom; // Nom de l'élément
        private int taille; // Taille de l'élément

        private boolean repertoire; // Vrai si c'est un répertoire
        private ArrayList<Noeud> fils; // Liste des fils du répertoire, null si c'est un fichier

        private final File file; // Fichier representé par le noeud

        /**
         * Constructeur de Noeud. Il prend un fichier et construit une arborescence de
         * manière récursive à partir de cet élément.
         * 
         * @param f fichier/dossier qui est representé par ce noeud
         * @throws FileNotFoundException Exception levée si le fichier n'est pas trouvé
         */
        public Noeud(File f) throws FileNotFoundException {

            if (!f.exists())
                throw new FileNotFoundException();

            nom = f.getName();
            taille = (int) f.length();

            repertoire = f.isDirectory();

            if (repertoire) {
                fils = new ArrayList<>();
                for (File enfant : f.listFiles()) {
                    try {
                        fils.add(new Noeud(enfant));
                    } catch (FileNotFoundException e) {
                        System.out.println("Could not open " + enfant.getAbsolutePath());
                        e.printStackTrace();
                    }
                }
            }

            file = f;
        }

        /**
         * Affiche récursivement l'arborescence, en laissant un espace au debut de
         * chaque ligne correspondant à la profondeur de l'élément affiché.
         * 
         * @param profondeur Profondeur du répertoire courant
         */
        public void afficher(int profondeur) {
            System.out.println("  ".repeat(profondeur) + nom + " [" + taille + "]");

            if (repertoire)
                for (Noeud enfant : fils)
                    enfant.afficher(profondeur + 1);

        }

        /**
         * Parcoure récursivement l'arborescence en renommant chaque nom comme le
         * résultat de l'application de t au nom du fichier.
         * 
         * @param t Fonction à appliquer au nom
         */
        public void map(StringTransformation t) {

            if (repertoire)
                fils.forEach((Noeud n) -> n.map(t));
            else
                nom = t.transf(nom);

        }

        /**
         * Affiche tous les élément qui ont une extension particulière. Pour chercher
         * tous les fichier te type "txt" il suffit d'appeler la fonction traverser
         * ainsi : noeud.traverser(".txt").
         * 
         * @param extension extension à chercher, avec le "."
         */
        public void traverser(String extension) {
            if (repertoire)
                fils.forEach((Noeud n) -> n.traverser(extension));
            else if (nom.endsWith(extension))
                afficher(0);
        }

        /**
         * Supprime un enfant d'un répertoire. Si le dossier n'a pas la permission
         * d'écriture une exception UnableToDeleteFileException est levée.
         * 
         * @param enfant Noeud a supprimer
         * @throws UnableToDeleteFileException Exception levé si on n'a pas la permisión
         *                                     d'écriture dans le dossier parent du
         *                                     fichier à supprimer.
         */
        private void deleteFile(Noeud enfant) throws UnableToDeleteFileException {
            if (repertoire) {
                if (enfant.file.getParentFile().canWrite())
                    fils.remove(enfant);
                else
                    throw new UnableToDeleteFileException(enfant.file.getPath());
            }
        }

        /**
         * Supprime de l'arborescence tous les fichier qui ont une extension
         * particulière. La suppression se fait que das la representation dans
         * l’arborescence des fichiers, on ne supprime pas les fichiers eux-même. De
         * plus elle leve l’exception UnableToDeleteFileException si on n'a pas la
         * permisión d'écriture dans le dossier parent.
         * 
         * @param extension extension à chercher, avec le "."
         * 
         */
        void supprimer(String extension) throws UnableToDeleteFileException {
            if (!repertoire)
                return;

            ArrayList<Noeud> enfantsASupprimer = new ArrayList<>();

            ArrayList<Boolean> flag = new ArrayList<>(); // Flag pour savoir s'il y a eu un fichier qui devrait être
                                                         // supprimé mais qui ne l'a pas été

            fils.forEach((Noeud enfant) -> {
                if (enfant.repertoire) {
                    try {
                        enfant.supprimer(extension);
                    } catch (UnableToDeleteFileException e) {
                        flag.add(true);
                    }
                } else if (enfant.nom.endsWith(extension))
                    enfantsASupprimer.add(enfant);
            });

            enfantsASupprimer.forEach((Noeud enfant) -> {
                try {
                    deleteFile(enfant);
                } catch (UnableToDeleteFileException e) {
                    System.out.println(e.getMessage());
                    flag.add(true);
                }
            });

            if (!flag.isEmpty())
                // Si un fichier qui devrait être supprimé n'a pas été supprimé alors on leve
                // l'exception.
                throw new UnableToDeleteFileException();

        }
    }

    /**
     * Construction d'un abre à partir d'un chemin vers un dossier qui va servir
     * comme racine de l'arborescence.
     * 
     * @param path Chemin vers la racine
     * @throws FileNotFoundException Exception levée si la racine n'est pas trouvée
     */
    public Arbre(String path) throws FileNotFoundException {
        racine = new Noeud(new File(path));

    }

    /**
     * Affichage récursif de l'arborescence.
     */
    public void afficher() {
        racine.afficher(0);
    }

    /**
     * Application d'une fonction String -> String pour renommer les fichiers.
     * 
     * @param t
     */
    public void map(StringTransformation t) {
        racine.map(t);
    }

    /**
     * Affiche les fichier qui ont une extension particulière. Pour chercher tous
     * les fichier te type txt on peut appeler la fonction de deux manières
     * diferentes:
     * 
     * <pre>
     * <blockquote>
     * traverser("txt") ou traverser(".txt")
     * </pre>
     * 
     * </blockquote>
     * 
     * @param extension Extension à chercher
     */
    public void traverser(String extension) {
        racine.traverser(extension.startsWith(".") ? extension : "." + extension);
    }

    /**
     * Supprime tous les fichier qui se terminent par {@code extension}. Pour
     * éliminer tous les fichiers de type <b>txt</b> on peut appeler la fonction de
     * deux manières diferentes:
     * 
     * <pre>
     * <blockquote>
     * supprimer("txt") ou supprimer(".txt")
     * </pre>
     * 
     * </blockquote>
     * 
     * Si le dossier parent d'un fichier à supprimer n'avait pas le droits
     * d'écriture alors on leve l'exception {@code UnableToDeleteFileException}.
     * 
     * 
     * @param extension Extension à chercher
     * @throws UnableToDeleteFileException Exception levée si un fichier n'a pas pu
     *                                     être supprimé
     */
    void supprimer(String extension) throws UnableToDeleteFileException {
        racine.supprimer(extension.startsWith(".") ? extension : "." + extension);

    }

    // Helper function
    private static void printLine() {
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        StringTransformation addBlah = (String s) -> s + ".blah";

        String path = "racine";

        new TestFunction() {
            public void function(Arbre a) {
                a.afficher();
            }
        }.runTest("afficher", path);

        new TestFunction() {
            public void function(Arbre a) {

                System.out.println("Avant map");
                a.afficher();

                a.map(addBlah);
                printLine();

                System.out.println("Après map");
                a.afficher();
            }
        }.runTest("map", path);

        new TestFunction() {
            public void function(Arbre a) {
                a.afficher();
                printLine();
                a.traverser("txt");
            }
        }.runTest("traverser avec txt", path);

        new TestFunction() {
            public void function(Arbre a) {

                System.out.println("Avant supprimer");
                a.afficher();

                printLine();

                try {
                    a.supprimer("txt");
                } catch (UnableToDeleteFileException e) {
                    System.out.println("Il y a eu un problème lors de la suppression des fichiers");
                }

                System.out.println("Après supprimer");
                a.afficher();

            }
        }.runTest("supprimer", path);
    }
}