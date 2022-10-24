package figures;

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

    public final double estDistantDe(Figure fig) {
        return Math.sqrt((posX - fig.posX) * (posX - fig.posX) + (posY - fig.posY) * (posY - fig.posY));
    }

    public abstract double surface();

    public abstract void affiche();

    public void deplacement(int x, int y) {
        posX += x;
        posY += y;
    }
}