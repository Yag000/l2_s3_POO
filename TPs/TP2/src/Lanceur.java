public class Lanceur {

    public static void main(String[] args) {
        /*
         * 
         * Test des premieres fonctions de Plateau
         * 
         * System.out.println("|=-=-=-=-=| Démineur |=-=-=-=-=-=|");
         * Plateau test1 = new Plateau(9,9,1);
         * Plateau test2 = new Plateau(10,10,50);
         * Plateau test3 = new Plateau(15,15,3);
         * Plateau test4 = new Plateau(30,30,300);
         * 
         * test1.afficheTout();
         * System.out.println("\n");
         * test2.afficheTout();
         * System.out.println("\n");
         * test3.afficheTout();
         * System.out.println("\n");
         * test4.afficheTout();
         * System.out.println("\n");
         * 
         * test1.drapeauCase(1, 1);
         * test1.drapeauCase(2, 2);
         * 
         * test1.afficheCourant();
         * test1.revelerCase(5,5);
         * test1.afficheCourant();
         * 
         */

        System.out.println("|=-=-=-=-=| Démineur |=-=-=-=-=-=|");

        Joueur joueur = new Joueur();
        joueur.setNom();
        while (joueur.veutJouer()) {
            int[] dimensions = joueur.demanderDimensions();
            int mines = joueur.demanderMines();
            Plateau plateau = new Plateau(dimensions[0], dimensions[1], mines);
            Jeu jeu = new Jeu(joueur, plateau);
            System.out.println();
            if (jeu.jouer())
                System.out.println("Bravo, vous avez gagne!");
            else
                System.out.println("BOOOOOOM, vous avez relevé une bombe");
        }
        joueur.finir();

    }
}
