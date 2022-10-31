package figures;

public abstract class Figure {
    // coordonnées du centre approximatif de la figure
    private int posX;
    private int posY;

    public Figure(int x, int y) {
        posX = x;
        posY = y;
    }

    /**
     * 
     * @return posX
     */
    public final int getPosX() {
        return posX;
    }

    /**
     * 
     * @return posY
     */
    public final int getPosY() {
        return posY;
    }

    /**
     * Renvoie la distance entre les centre de deux figures
     * 
     * @param fig la figure a comparer
     * @return la distance
     */
    public final double estDistantDe(Figure fig) {
        return Math.sqrt((posX - fig.posX) * (posX - fig.posX) + (posY - fig.posY) * (posY - fig.posY));
    }

    /**
     * 
     * @return La surface de la figure
     */
    public abstract double surface();

    /**
     * Affiche les informations de la figure
     */
    public abstract void affiche();

    /**
     * Déplace la figure vers dans la direction (x,y)
     * 
     * @param x deplacement horizontal
     * @param y deplacement vertical
     */

    public void deplacement(int x, int y) {
        posX += x;
        posY += y;
    }
}