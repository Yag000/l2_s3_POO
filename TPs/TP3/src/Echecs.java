public class Echecs {

    private boolean joueur = true;

    public Plateau initialiser() {

        Plateau plateau = new Plateau(8, 8);

        for (int i = 0; i < 8; i++) {
            plateau.remplirCase(i, 1, new Pion(false));
            plateau.remplirCase(i, 6, new Pion(true));
        }

        plateau.remplirCase(0, 0, new Tour(false));
        plateau.remplirCase(7, 0, new Tour(false));
        plateau.remplirCase(0, 7, new Tour(true));
        plateau.remplirCase(7, 7, new Tour(true));

        plateau.remplirCase(1, 0, new Cavalier(false));
        plateau.remplirCase(6, 0, new Cavalier(false));
        plateau.remplirCase(1, 7, new Cavalier(true));
        plateau.remplirCase(6, 7, new Cavalier(true));

        plateau.remplirCase(2, 0, new Fou(false));
        plateau.remplirCase(5, 0, new Fou(false));
        plateau.remplirCase(2, 7, new Fou(true));
        plateau.remplirCase(5, 7, new Fou(true));

        plateau.remplirCase(3, 0, new Dame(false));
        plateau.remplirCase(3, 7, new Dame(true));

        plateau.remplirCase(4, 0, new Roi(false));
        plateau.remplirCase(4, 7, new Roi(true));

        return plateau;

    }

    /**
     * Ça joue un tour
     * 
     * @param d      le coup à jouer
     * @param joueur le joueur qui joue
     * @param p      le tableau
     * @return la dernière piece perdue
     */
    public String jouerTour(Deplacement d, Plateau p) {
        return p.deplacer(d);
    }

    /**
     * Il demande au joueur un coup, vérifie s'il est valide, le joue, puis change
     * de joueur
     * 
     */
    public void jouerPartie() {
        Plateau p = this.initialiser();
        p.afficher();
        String lastLost = "";

        while (lastLost == null || !lastLost.equals("roi")) {
            Deplacement d = Communication.demanderDeplacement(joueur, p.getLongeur());

            while (p.getCase(d.getX0(), d.getY0()).estVide() ||
                    !p.getCase(d.getX0(), d.getY0()).getPiece().estValide(d, p) ||
                    !p.getCase(d.getX0(), d.getY0()).getPiece().getCouleur() == joueur) {
                System.out.println("Mouvement impossible");
                d = Communication.demanderDeplacement(joueur, p.getLongeur());

            }
            lastLost = jouerTour(d, joueur, p).toLowerCase();
            p.afficher();
            joueur = !joueur;
        }
        System.out.println((!this.joueur ? "Blanc" : "Noir") + " a gagné");
    }

    public static void main(String[] args) {
        Echecs e = new Echecs();
        e.jouerPartie();
    }

}
