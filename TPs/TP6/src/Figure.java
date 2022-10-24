public abstract class Figure {
    // coordonnées du centre approximatif de la figure
    private int posX;
    private int posY;

    public Figure(int x, int y) {
        posX = x;
        posY = y;
    }

    public final int getPosX() {
        return posX;
    }

    public final int getPosY() {
        return posY;
    }

    public abstract void affiche();
}