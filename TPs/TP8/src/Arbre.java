import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arbre {

    private Noeud racine;

    private class Noeud {
        private String nom;
        private int taille;

        private boolean repertoire;
        private ArrayList<Noeud> fils;

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
                    }
                }
            }
        }

        public void afficher(int profondeur) {
            System.out.println("  ".repeat(profondeur) + nom + " [" + taille + "]");

            if (repertoire)
                for (Noeud enfant : fils)
                    enfant.afficher(profondeur + 1);

        }

        public void map(StringTransformation t) {

            if (repertoire)
                fils.forEach((Noeud n) -> n.map(t));
            else
                nom = t.transf(nom);

        }

        public void traverser(String extension) {
            if (repertoire)
                fils.forEach((Noeud n) -> n.traverser(extension));
            else if (nom.endsWith("." + extension))
                afficher(0);
        }
    }

    public Arbre(String path) throws FileNotFoundException {
        racine = new Noeud(new File(path));
    }

    public void afficher() {
        racine.afficher(0);
    }

    public void map(StringTransformation t) {
        racine.map(t);
    }

    public void traverser(String extension) {
        racine.traverser(extension);
    }

    public static void main(String[] args) {
        StringTransformation addBlah = (String s) -> s + ".blah";

        String path = "./Test/racine";

        new TestFunction() {
            public void function(Arbre a) {
                a.afficher();
            };
        }.runTest("afficher", path);

        new TestFunction() {
            public void function(Arbre a) {

                System.out.print("Avant le map");
                a.afficher();

                System.out.println("--------------------");

                a.map(addBlah);

                System.out.print("Après le map");
                a.afficher();
            };
        }.runTest("map", path);

        new TestFunction() {
            public void function(Arbre a) {
                a.afficher();

                System.out.println("--------------------");

                a.traverser("txt");

            };
        }.runTest("traverser avec txt", path);

    }
}
