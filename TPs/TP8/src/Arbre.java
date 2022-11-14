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

    public static void main(String[] args) {
        StringTransformation addBlah = (String s) -> s + ".blah";

        Arbre test;

        try {
            test = new Arbre("./Test/racine");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Le fichier n'existe pas");
            return;
        }

        System.out.println("--------------------");

        test.afficher();

        test.map(addBlah);

        System.out.println("--------------------");

        test.afficher();
    }
}
