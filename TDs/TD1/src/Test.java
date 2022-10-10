public class Test {
    public static void main(String[] args) {
        Personne tony = new Personne("Parker", "Tony", 29, 10);
        System.out.println(tony);
        Personne mickael = tony;
        mickael.setPrenom("Mickael");
        System.out.println(tony);// équivalent à System.out.println(tony.toString());
        // Voir remarque

        Personne p1 = new Personne("Felagund", "Finrod", 3015, 10000);
        Personne p2 = new Personne("Celebrindal", "Idril", 1029, 10);

        System.out.println();
        System.out.println("-------- Test whith 10 --------");
        Personne.donne(p1, p2, 10);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println();
        System.out.println("-------- Test whith 10000 --------");

        Personne.donne(p1, p2, 10000);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println();
        System.out.println("-------- Test whith 30 --------");
        p1.donne(p2, 30);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println();
        System.out.println("-------- Test whith 30000 --------");
        p1.donne(p2, 30000);
        System.out.println(p1);
        System.out.println(p2);

        // I feel inclined to use the second one

    }
}