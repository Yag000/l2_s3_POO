import java.util.LinkedList;
import java.util.Scanner;

import java.io.File;

/**
 * Classe qui représente un formateur de texte plus avancée qui a une limite de
 * caractères par ligne, qui indente les paragraphes et qui les justifie.
 */
public class FormateurJoli extends Formateur {
    private int maxLengthPage;
    private LinkedList<ParagrapheJoli> texte;

    public FormateurJoli(String filename, int maxLengthPage) {
        super(filename);
        this.maxLengthPage = maxLengthPage;

        sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("Erreur lors d´ouverture fichier:");
            e.printStackTrace();
            System.exit(1);
        }
        texte = new LinkedList<ParagrapheJoli>();
    }

    @Override
    public void read() {
        sc.useDelimiter("\n\\s*\n");
        while (sc.hasNext()) { /* tant qu’il reste un paragraphe `a lire */
            ParagrapheJoli p = readParagraphe();
            texte.add(p);
        }
    }

    /**
     * La fonction lit un paragraphe du flux d'entrée et le renvoie sous la
     * forme*d'un objet ParagrapheJoli
     * 
     * @return Le paragraphe joli.
     */

    private ParagrapheJoli readParagraphe() {
        Espace tab = new Espace();
        tab.setSize(4);
        ParagrapheJoli paragraphe = new ParagrapheJoli(maxLengthPage);
        paragraphe.addChaine(tab);
        String para = sc.next(); /* on extrait le paragraphe suivant */
        Scanner s = new Scanner(para); /* on initialise un nouveau scanner sur ce paragraphe */

        while (s.hasNext()) {
            paragraphe.addChaine(new Mot(s.next()));
            paragraphe.addChaine(new Espace());
        }
        s.close();
        return paragraphe;
    }

    @Override
    public void print() {
        for (ParagrapheJoli p : texte)
            System.out.println(p);
    }

    public static void main(String[] args) {
        printTest("texte");
        FormateurJoli texte = new FormateurJoli("./textes/texte", 7);
        texte.read();
        texte.print();

        printTest("texteBis");
        FormateurJoli texteBis = new FormateurJoli("./textes/texteBis", 50);
        texteBis.read();
        texteBis.print();

        printTest("vide");
        FormateurJoli vide = new FormateurJoli("./textes/vide", 1);
        vide.read();
        vide.print();

        printTest("videBis");
        FormateurJoli videBis = new FormateurJoli("./textes/videBis", 49);
        videBis.read();
        videBis.print();
    }
}
