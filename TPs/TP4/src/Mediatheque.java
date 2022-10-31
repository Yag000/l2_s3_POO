import java.util.ArrayList;

public class Mediatheque {
    private ArrayList<Media> baseDeDonnees;

    public Mediatheque() {
        this.baseDeDonnees = new ArrayList<Media>();
    }
    /**
     * Il ajoute un nouveau média à la base de données, au bon endroit
     * 
     * @param doc le média à ajouter à la base de données
     */
    public void ajouter(Media doc) {
        for (int i = 0; i < baseDeDonnees.size(); i++) {
            if (doc.plusPetit(baseDeDonnees.get(i))) {
                baseDeDonnees.add(i, doc);
                return;
            }
        }
        baseDeDonnees.add(doc);
    }

    /**
     * Imprime trous les livres de la médiathèque.
     */
    public void tousLesLivres() {
        for (Media m : baseDeDonnees)
            if (m instanceof Livre)
                System.out.println(m);
    }


    /**
     * Renvoie une liste de tous les médias de la base de données qui satisfont
     * le prédicat p
     * 
     * @param p un prédicat
     * @return Une ArrayList d'objets Media.
     */
    public ArrayList<Media> recherche(Predicat p) {
        ArrayList<Media> res = new ArrayList<Media>();
        for (Media m : baseDeDonnees)
            if (p.estVrai(m))
                res.add(m);
        return res;
    }

    /**
     * Affiche tous les medias dans une liste de medias,
     * 
     * @param list ArrayList des objets Media à afficher.
     */
    public static void printArrayListMedia(ArrayList<Media> list) {
        for (Media m : list) {
            System.out.println(m);
        }
    }

    @Override
    public String toString() {
        String s = "";

        for (Media m : baseDeDonnees)
            s += m + "\n";

        return s;
    }


    /**
     * Il affiche un en-tête pour un test
     * 
     * @param s le nom de l'épreuve
     */
    private static void printTest(String s) {
        System.out.println();
        System.out.println("---------\\ Test de " + s + " /---------");
        System.out.println();
    }

    public static void main(String[] args) {

        printTest("ajouter");

        Mediatheque m = new Mediatheque();

        LongMetrage lotrFF = new LongMetrage("The Lord of the Rings: The Fellowship of The Ring", 228,
                "Peter Jackson");
        LongMetrage lotrTF = new LongMetrage("The Lord of the Rings: The Two Towers", 235, "Peter Jackson");
        LongMetrage lotrRF = new LongMetrage("The Lord of the Rings: The Return of the King", 251, "Peter Jackson");

        Livre lotrFB = new Livre("The Lord of the Rings: The Fellowship of The Ring", "John Ronald Reuel Tolkien",
                423);
        Livre lotrTB = new Livre("The Lord of the Rings: The Two Towers", "John Ronald Reuel Tolkien", 352);
        Livre lotrRB = new Livre("The Lord of the Rings: The Return of the King", "John Ronald Reuel Tolkien", 416);

        Livre silmarillion = new Livre("The Silmarillion", "John Ronald Reuel Tolkien", 365);

        Image gondolin = new Image("Guard of Gondolin", 456, 750);


        Manga hxh = new Manga("Hunter x Hunter", "Yoshihiro Togashi", 192, "Yoshihiro Togashi", true);

        m.ajouter(lotrRB);
        m.ajouter(lotrRF);
        m.ajouter(silmarillion);

        m.ajouter(gondolin);
        m.ajouter(lotrFB);
        m.ajouter(hxh);

        m.ajouter(lotrTB);

        m.ajouter(lotrFF);

        m.ajouter(lotrTF);

        System.out.println(m);

        printTest("tout les livres");

        m.tousLesLivres();

        printTest("recherche de p1");

        Et p1 = new Et(new EstUnLivre(), new TitreCommencePar('S'));
        Mediatheque.printArrayListMedia(m.recherche(p1));

        printTest("recherche de p2");

        Et p2 = new Et(new EstUnLivre(), new TitreCommencePar('T'));
        Mediatheque.printArrayListMedia(m.recherche(p2));

        printTest("recherche de avec distance de Levenshtein de p3");

        TitreEstAPeuPres p3 = new TitreEstAPeuPres("The Silmarilion", 1);
        Mediatheque.printArrayListMedia(m.recherche(p3)); // "The Silmarillion"

        printTest("recherche de avec distance de Levenshtein de p4");
        TitreEstAPeuPres p4 = new TitreEstAPeuPres("The Silmarilion", 2);
        Mediatheque.printArrayListMedia(m.recherche(p4)); // "The Silmarillion"

        printTest("recherche de avec distance de Levenshtein de p5");
        TitreEstAPeuPres p5 = new TitreEstAPeuPres("The Silmion", 2);
        Mediatheque.printArrayListMedia(m.recherche(p5)); // None

        printTest("recherche de avec distance de Levenshtein de p6");
        TitreEstAPeuPres p6 = new TitreEstAPeuPres("The Silmart45ton", 7);
        Mediatheque.printArrayListMedia(m.recherche(p6)); // The Silmarillion

        printTest("recherche de avec distance de Levenshtein de p7");
        TitreEstAPeuPres p7 = new TitreEstAPeuPres("The ", 12);
        Mediatheque.printArrayListMedia(m.recherche(p7)); // The Silmarillion

        printTest("recherche de avec distance de Levenshtein de p8");
        TitreEstAPeuPres p8 = new TitreEstAPeuPres("", 20);
        Mediatheque.printArrayListMedia(m.recherche(p8)); // Tous les titres avec une longueur inférieur à 20

        printTest("recherche de avec distance de Levenshtein de p9");
        TitreEstAPeuPres p9 = new TitreEstAPeuPres("The Silmerillien", 2);
        Mediatheque.printArrayListMedia(m.recherche(p9)); // The Silmarillion

        printTest("recherche de avec distance de Levenshtein de p10");
        TitreEstAPeuPres p10 = new TitreEstAPeuPres("The Silmerellien", 2);
        Mediatheque.printArrayListMedia(m.recherche(p10)); // None

        printTest("recherche de sous-chaîne de p11");
        ContientSousChaine p11 = new ContientSousChaine("The");
        Mediatheque.printArrayListMedia(m.recherche(p11));
    }
}