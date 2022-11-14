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
    }

    public Arbre(String path) throws FileNotFoundException {
        racine = new Noeud(new File(path));
    }
}
