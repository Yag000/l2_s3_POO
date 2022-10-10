public class Plateau {

    private final int hauteur, largeur, nbMines;
    private int nbDrapeaux;
    private boolean[][] mines;
    private int[][] etats;
    private int[][] adja;

    public Plateau(int ha, int la, int mi) {
        this.hauteur = ha;
        this.largeur = la;
        this.nbMines = mi;
        this.nbDrapeaux = 0;

        this.mines = new boolean[ha + 2][la + 2];
        this.etats = new int[ha + 2][la + 2];
        this.adja = new int[ha + 2][la + 2];

        this.ajouteMinesAlea();
        this.calculeAdjacence();
    }

    /**
     * Ajoute nbMines mines de maniere aleatoire
     */
    private void ajouteMinesAlea() {
        int placed = 0;

        while (placed < this.nbMines) {
            int posX = (int) (Math.random() * this.hauteur + 1);
            int posY = (int) (Math.random() * this.largeur + 1);
            if (!this.mines[posX][posY]) {
                this.mines[posX][posY] = true;
                placed++;
            }
        }
    }

    /**
     * Si mines[i][j] est une mine, alors il
     * rajoute 1 au compteur de mines de
     * chauqe case adjacente
     * 
     * @param i Largeur
     * @param j Longeur
     */

    private void computeAdja(int i, int j) {
        if (this.mines[i][j]) {
            this.adja[i - 1][j - 1]++;
            this.adja[i - 1][j]++;
            this.adja[i - 1][j + 1]++;

            this.adja[i][j - 1]++;
            this.adja[i][j + 1]++;

            this.adja[i + 1][j - 1]++;
            this.adja[i + 1][j]++;
            this.adja[i + 1][j + 1]++;
        }
    }

    /**
     * Itere computeAdja dans toutes les cases
     */

    private void calculeAdjacence() {
        for (int i = 1; i <= this.hauteur; i++) {
            for (int j = 1; j <= this.largeur; j++)
                computeAdja(i, j);
        }
    }

    /**
     * Affiche le nombre de mines, de drapeaux
     * et le nombre de mines adjacentes a chaque case
     */
    public void afficheTout() {
        System.out.println("    **********************");
        System.out.println("    * Mines   / Drapeaux *");
        System.out.println("    * " + this.nbMines + " ".repeat(6 - ((int) Math.log10(this.nbMines))) + "/ " +
                this.nbDrapeaux
                + (this.nbDrapeaux == 0 ? "      " : (" ".repeat(6 - ((int) Math.log10(this.nbDrapeaux))))) + "   *");
        System.out.println("    **********************");
        System.out.println();

        System.out.print("    ");
        for (int i = 1; i <= this.largeur; i++)
            System.out.print(i + " ".repeat((i < 10 ? 2 + (this.largeur / 10 == 0 ? 0 : 1) : 2)));
        System.out.println();
        System.out.println(
                "-".repeat(3 * this.largeur + 4) + "-".repeat((this.largeur / 10 == 0 ? 0 : 1) * this.largeur));

        for (int i = 0; i < this.hauteur; i++) {
            System.out.print((char) ((int) 'A' + i) + " | ");
            for (int j = 0; j < this.largeur; j++) {
                System.out.print((this.mines[i + 1][j + 1] ? "*" : this.adja[i + 1][j + 1])
                        + " ".repeat(2 + (this.largeur / 10 == 0 ? 0 : 1)));
            }
            System.out.println();
        }
    }

    /**
     * Releve la case i,j et si la cases n'a
     * aucune mine adjacente on releve les cases
     * adjacentes.
     * 
     * @param i Longeur
     * @param j Largeur
     */
    public void revelerCase(int i, int j) {
        if (this.etats[i][j] == 1) {
            System.out.println("Drapeau");
            return;
        }

        this.etats[i][j] = 2;

        if (this.adja[i][j] == 0) {

            if (i - 1 > 0 && j - 1 > 0 && this.etats[i - 1][j - 1] == 0)
                this.revelerCase(i - 1, j - 1);
            if (i - 1 > 0 && this.etats[i - 1][j] == 0)
                this.revelerCase(i - 1, j);
            if (i - 1 > 0 && j + 1 <= this.hauteur && this.etats[i - 1][j + 1] == 0)
                this.revelerCase(i - 1, j + 1);

            if (j - 1 > 0 && this.etats[i][j - 1] == 0)
                this.revelerCase(i, j - 1);
            if (j + 1 <= this.hauteur && this.etats[i][j + 1] == 0)
                this.revelerCase(i, j + 1);

            if (i + 1 <= this.largeur && j - 1 > 0 && this.etats[i + 1][j - 1] == 0)
                this.revelerCase(i + 1, j - 1);
            if (i + 1 <= this.largeur && this.etats[i + 1][j] == 0)
                this.revelerCase(i + 1, j);
            if (i + 1 <= this.largeur && j + 1 <= this.hauteur && this.etats[i + 1][j + 1] == 0)
                this.revelerCase(i + 1, j + 1);
        }
    }

    /**
     * On place un drapeau ou on
     * l'enleve dans la case i,j
     * 
     * @param i Longeur
     * @param j Largeur
     */

    public void drapeauCase(int i, int j) {
        if (this.etats[i][j] == 2) {
            System.out.println("Case deja revelee");
            return;
        }

        if (this.etats[i][j] == 1) {
            this.etats[i][j] = 0;
            this.nbDrapeaux--;
        }

        if (this.etats[i][j] == 0 && this.nbDrapeaux < this.nbMines) {
            this.etats[i][j] = 1;
            this.nbDrapeaux++;
        }
    }

    /**
     * Affichage du plateau courrnt:
     * - Les mines adjacentes des cases releves
     * - Les cases non releves
     * - Les drapeaux mis
     */

    public void afficheCourant() {
        System.out.println("    **********************");
        System.out.println("    * Mines   / Drapeaux *");
        System.out.println("    * " + this.nbMines + " ".repeat(6 - ((int) Math.log10(this.nbMines))) + "/ " +
                this.nbDrapeaux
                + (this.nbDrapeaux == 0 ? "      " : (" ".repeat(6 - ((int) Math.log10(this.nbDrapeaux))))) + "   *");
        System.out.println("    **********************");
        System.out.println();

        System.out.print("    ");
        for (int i = 1; i <= this.largeur; i++)
            System.out.print(i + " ".repeat((i < 10 ? 2 + (this.largeur / 10 == 0 ? 0 : 1) : 2)));
        System.out.println();
        System.out.println(
                "-".repeat(3 * this.largeur + 4) + "-".repeat((this.largeur / 10 == 0 ? 0 : 1) * this.largeur));

        for (int i = 0; i < this.hauteur; i++) {
            System.out.print((char) ((int) 'A' + i) + " | ");
            for (int j = 0; j < this.largeur; j++) {
                System.out.print((this.etats[i + 1][j + 1] == 0 ? "."
                        : (this.etats[i + 1][j + 1] == 1 ? "!" : this.adja[i + 1][j + 1]))
                        + " ".repeat(2 + (this.largeur / 10 == 0 ? 0 : 1)));
            }
            System.out.println();
        }
    }

    /**
     * 
     * @return True si le jeu est perdu
     */
    public boolean jeuPerdu() {
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.mines[i][j] && this.etats[i][j] == 2)
                    return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return True si le jeu est gagne
     */

    public boolean jeuGagne() {
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.mines[i][j] && this.etats[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

}
