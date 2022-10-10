public class Combat {
    public static void main(String[] args) {
        Personnage p1 = new Personnage("Sauron", new Informations(30, 10, 5));
        Personnage p2 = new Personnage("Finrod Felagund", new Informations(20, 7, 100));

        System.out.println("Version iterative");

        Personnage.lutteIt(p1, p2);

        p1.rebirth();
        p2.rebirth();

        System.out.println("Version recursive");

        Personnage.lutteRec(p1, p2);
    }
}
