public class Echecs {

    private boolean joueur = true;

    public Plateau initialiser(){

        Plateau plateau = new Plateau(8, 8);


        for (int i = 0; i < 8; i++){
            plateau.remplirCase(i, 1, new Pion(false));
            plateau.remplirCase(i, 6, new Pion(true));
        }

        plateau.remplirCase(0,0, new Tour(false));
        plateau.remplirCase(7,0, new Tour(false));
        plateau.remplirCase(0,7, new Tour(true));
        plateau.remplirCase(7,7, new Tour(true));

        plateau.remplirCase(1,0, new Cavalier(false));
        plateau.remplirCase(6,0, new Cavalier(false));
        plateau.remplirCase(1,7, new Cavalier(true));
        plateau.remplirCase(6,7, new Cavalier(true));

        plateau.remplirCase(2,0, new Fou(false));
        plateau.remplirCase(5,0, new Fou(false));
        plateau.remplirCase(2,7, new Fou(true));
        plateau.remplirCase(5,7, new Fou(true));

        plateau.remplirCase(3,0, new Dame(false));
        plateau.remplirCase(3,7, new Dame(true));

        plateau.remplirCase(4,0, new Roi(false));
        plateau.remplirCase(4,7, new Roi(true));

        return plateau;

    }

    /**
     * Ça joue un tour
     * 
     * @param d le coup à jouer
     * @param joueur le joueur qui joue
     * @param p le tableau
     * @return la derniere piece perdue
     */
    public Piece jouerTour(Deplacement d,boolean joueur, Plateau p){
        if (p.getCase(d.getX0(),d.getY0()).getPiece().getCouleur() == joueur 
        && p.getCase(d.getX0(),d.getY0()).getPiece().estValide(d, p)){
            return p.deplacer(d);
        }
        return null;
    }

    /**
     * Il demande au joueur un coup, vérifie s'il est valide, le joue, puis change de joueur
     * 
     */
    public void jouerPartie(){
        Plateau p = this.initialiser();
        p.afficher();
        Piece lastLost = null;
        while (lastLost == null || !lastLost.estRoi()){
            Deplacement d = Communication.demanderDeplacement(joueur,8);
            while(!p.getCase(d.getX0(),d.getY0()).getPiece().estValide(d, p)){
                System.out.println("Mouvement impossible");
                d = Communication.demanderDeplacement(joueur,8);
            }
            lastLost = jouerTour(d,joueur,p);
            p.afficher();
            joueur = !joueur;
        }
        System.out.println(!this.joueur ? "Blanc" : "Noir" + " a gagné");
    }

    public static void main(String[] args) {
        /*
        Plateau plateau = new Plateau(8, 8);

        for (int i = 0; i < 8; i++){
            plateau.remplirCase(1, i, new Pion(false));
            plateau.remplirCase(6, i, new Pion(true));
        }

        plateau.remplirCase(0, 0, new Tour(false));
        plateau.remplirCase(0, 7, new Tour(false));
        plateau.remplirCase(7, 0, new Tour(true));
        plateau.remplirCase(7, 7, new Tour(true));

        plateau.remplirCase(0, 1, new Cavalier(false));
        plateau.remplirCase(0, 6, new Cavalier(false));
        plateau.remplirCase(7, 1, new Cavalier(true));
        plateau.remplirCase(7, 6, new Cavalier(true));

        plateau.remplirCase(0, 2, new Fou(false));
        plateau.remplirCase(0, 5, new Fou(false));
        plateau.remplirCase(7, 2, new Fou(true));
        plateau.remplirCase(7, 5, new Fou(true));

        plateau.remplirCase(0, 3, new Dame(false));
        plateau.remplirCase(7, 3, new Dame(true));
        
        plateau.remplirCase(0, 4, new Roi(false));
        plateau.remplirCase(7, 4, new Roi(true));

        plateau.afficher();
        */

        Echecs e = new Echecs();

        e.jouerPartie();

    }
    
}
