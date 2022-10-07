public class Plateau {
    private int longeur, largeur;
    private Case[][] plateau;

    public Plateau(int longeur, int largeur) {
        this.longeur = longeur;
        this.largeur = largeur;
        this.plateau = new Case[longeur][largeur];

        for (int i = 0; i < longeur; i++) {
            for (int j = 0; j < largeur; j++) {
                plateau[i][j] = new Case((i + j) % 2 == 1);
            }
        }
    }

    /**
     * Cette fonction renvoie vrai si les coordonnées données sont dans les limites
     * du plateau.
     * 
     * @param i le numéro de colonne
     * @param j le numéro de ligne
     * @return La valeur booléenne de l'instruction.
     */
    public boolean horsLimite(int i, int j) {
        return j < longeur && j >= 0 && i < largeur && i >= 0;
    }

    /**
     * Cette fonction renvoie vrai si les deux points du deplacement
     * sont compris dans le plateau.
     * 
     * @param deplacement le mouvement à vérifier
     * @return Une valeur booléenne.
     */
    public boolean horsLimite(Deplacement deplacement) {
        return horsLimite(deplacement.getX0(), deplacement.getY0()) ||
                horsLimite(deplacement.getX1(), deplacement.getY1());
    }

    public Case getCase(int i, int j) {
        if (!this.horsLimite(i, j))
            return null;
        return plateau[j][i];
    }

    public void videCase(int x, int y) {
        if (this.horsLimite(x, y))
            plateau[y][x].enleverPiece();
    }

    /**
     * Il remplit une caisse avec un piece
     * 
     * @param x la coordonnée x du cas
     * @param y la coordonnée y de la pièce
     * @param p la pièce à placer sur le plateau
     */
    public void remplirCase(int x, int y, Piece p) {
        if (this.horsLimite(x, y))
            plateau[y][x].remplirPiece(p);
    }

    /**
     * Cette fonction vérifie si le chemin entre le début et la fin d'un mouvement
     * est vide
     * 
     * @param d le déménagement
     * @return La méthode renvoie une valeur booléenne.
     */
    public boolean intermVides(Deplacement d) {
        switch (d.typeDeplacement()) {
            case 'h': {
                for (int i = 1; i < Math.abs(d.getX0() - d.getX1()); i++) {
                    if (!plateau[d.getY0()][d.getX0() < d.getX1() ? d.getX0() + i : d.getX0() - i].estVide()) {
                        return false;
                    }
                }
            }

                return true;
            case 'v': {
                for (int j = 1; j < Math.abs(d.getY0() - d.getY1()); j++) {
                    if (!plateau[d.getY0() < d.getY1() ? d.getY0() + j : d.getY0() - j][d.getX0()].estVide()) {

                        return false;
                    }
                }
                return true;
            }

            case 'd': {
                int i = d.getX0() < d.getX1() ? 1 : -1;
                int j = d.getY0() < d.getY1() ? 1 : -1;
                for (int k = 1; k < Math.abs(d.getX0() - d.getX1()); k++) {
                    if (!plateau[d.getY0() + k * j][d.getX0() + k * i].estVide()) {
                        return false;
                    }
                }
                return true;
            }

            default:
                return true;
        }
    }

    /**
     * Cette fonction déplace une pièce d'une case à une autre
     * 
     * @param d le geste à faire
     */
    public String deplacer(Deplacement d) {
        String lost = this.getCase(d.getX1(), d.getY1()).estVide() ? ""
                : this.getCase(d.getX1(), d.getY1()).getPiece().nom;
        this.videCase(d.getX1(), d.getY1());
        this.remplirCase(d.getX1(), d.getY1(), this.getCase(d.getX0(), d.getY0()).getPiece());
        this.videCase(d.getX0(), d.getY0());
        return lost;
    }

    /**
     * Cette fonction affiche le tableau
     */
    public void afficher() {
        System.out.print("   | ");
        for (int i = 0; i < longeur; i++)
            System.out.print((char) (i + 'a') + " ");
        System.out.println("|");

        System.out.println("---|" + "-".repeat(longeur * 2) + "-|--");

        for (int i = 0; i < longeur; i++) {
            System.out.print(" " + (largeur - i) + " | ");
            for (int j = 0; j < largeur; j++) {
                System.out.print(this.plateau[i][j] + " ");
            }
            System.out.println("| " + (largeur - i));
        }

        System.out.println("---|" + "-".repeat(longeur * 2) + "-|--");

        System.out.print("   | ");
        for (int i = 0; i < longeur; i++)
            System.out.print((char) (i + 'a') + " ");
        System.out.println("|");
    }

    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }

}
