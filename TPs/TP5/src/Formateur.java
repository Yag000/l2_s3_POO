import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class Formateur {

    protected Scanner sc;
    private LinkedList<Paragraphe> texte;

    // fic est le nom du fichier,
    // chemin compris s’il n’est pas dans le même répertoire
    public Formateur(String filename) {
        sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("Erreur lors d´ouverture fichier:");
            e.printStackTrace();
            System.exit(1);
        }
        texte = new LinkedList<Paragraphe>();
    }

    // TODO: solve space at the end f document
    // TODO: solve useless lines.

    public void read() {
        sc.useDelimiter("\n\\s*\n");
        while (sc.hasNext()) { /* tant qu’il reste un paragraphe `a lire */
            Paragraphe p = readParagraphe();
            texte.add(p);
        }
    }

    private Paragraphe readParagraphe() {
        Paragraphe paragraphe = new Paragraphe();
        String para = sc.next(); /* on extrait le paragraphe suivant */
        Scanner s = new Scanner(para); /* on initialise un nouveau scanner sur ce paragraphe */
        /*
         * s.useDelimiter("\\s+"); pas nécessaire puisque \\s+ est le délimiteur par
         * défaut
         */
        while (s.hasNext()) {
            paragraphe.addChaine(new Mot(s.next()));
            paragraphe.addChaine(new Espace());
        }
        return paragraphe;
    }

    public void print() {
        for (Paragraphe p : texte) {
            System.out.println(p);
        }
    }

    /**
     * Il affiche un en-tête pour un test
     * 
     * @param s le nom de l'épreuve
     */
    public static void printTest(String s) {
        System.out.println();
        System.out.println("---------\\ Test de " + s + " /---------");
        System.out.println();
    }

    public static void main(String[] args) {

        printTest("texte");
        Formateur texte = new Formateur("./textes/texte");
        texte.read();
        texte.print();

        printTest("texteBis");
        Formateur texteBis = new Formateur("./textes/texteBis");
        texteBis.read();
        texteBis.print();

        printTest("vide");
        Formateur vide = new Formateur("./textes/vide");
        vide.read();
        vide.print();

        printTest("videBis");
        Formateur videBis = new Formateur("./textes/videBis");
        videBis.read();
        videBis.print();

    }
}
