import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

/**
 * Formateur de texte basique
 */
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

    /**
     * La fonction lit un fichier texte et le stocke dans une liste de paragraphes
     */
    public void read() {
        sc.useDelimiter("\n\\s*\n");
        while (sc.hasNext()) { // Boucle sur les paragraphes
            Paragraphe p = readParagraphe();
            texte.add(p);
        }
    }

    /**
     * La fonction lit un paragraphe du flux d'entrée et le renvoie sous la forme
     * d'un objet Paragraphe
     * 
     * @return Le paragraphe lu.
     */

    private Paragraphe readParagraphe() {
        Paragraphe paragraphe = new Paragraphe();
        String para = sc.next(); // on extrait le paragraphe suivant
        Scanner s = new Scanner(para); // on initialise un nouveau scanner sur ce paragraphe

        while (s.hasNext()) {
            paragraphe.addChaine(new Mot(s.next()));
            if (s.hasNext())
                paragraphe.addChaine(new Espace());
        }

        s.close();
        return paragraphe;
    }

    /**
     * Affiche un texte deja lu
     */
    public void print() {
        for (Paragraphe p : texte) {
            System.out.println(p + "\n");
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
        Formateur texte = new Formateur("texte");
        texte.read();
        texte.print();

        printTest("texteBis");
        Formateur texteBis = new Formateur("texteBis");
        texteBis.read();
        texteBis.print();

        printTest("vide");
        Formateur vide = new Formateur("vide");
        vide.read();
        vide.print();

        printTest("videBis");
        Formateur videBis = new Formateur("videBis");
        videBis.read();
        videBis.print();

    }
}
