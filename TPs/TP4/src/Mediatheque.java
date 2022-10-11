import java.util.ArrayList;

public class Mediatheque {
    private ArrayList<Media> baseDeDonnees;

    public Mediatheque() {
        this.baseDeDonnees = new ArrayList<Media>();
    }

    public void ajouter(Media doc) {

        for (int i = 0; i < baseDeDonnees.size(); i++) {
            if (doc.plusPetit(baseDeDonnees.get(i))) {
                baseDeDonnees.add(i, doc);
                return;
            }

        }

        baseDeDonnees.add(doc);

    }

    public void tousLesLivres() {
        for (Media m : baseDeDonnees)
            if (m instanceof Livre)
                System.out.println(m);
    }

    public ArrayList<Media> recherche(Predicat p) {
        ArrayList<Media> res = new ArrayList<Media>();
        for (Media m : baseDeDonnees)
            if (p.estVrai(m))
                res.add(m);
        return res;
    }

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

    public static void main(String[] args) {
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

        Manga hxh = new Manga("HUnter x Hunter", "Yoshihiro Togashi", 192, "Yoshihiro Togashi", true);

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

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        m.tousLesLivres();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        Et p1 = new Et(new EstUnLivre(), new TitreCommencePar('S'));
        Et p2 = new Et(new EstUnLivre(), new TitreCommencePar('T'));

        Mediatheque.printArrayListMedia(m.recherche(p1));

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        Mediatheque.printArrayListMedia(m.recherche(p2));

    }

}
