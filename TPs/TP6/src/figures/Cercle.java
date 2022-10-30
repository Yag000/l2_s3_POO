package figures;

public class Cercle extends Ellipse {

    public Cercle(int x, int y, double rayon) {
        super(x, y, rayon, rayon);
    }

    @Override
    public String toString() {
        return "Cercle [posX= " + getPosX() + ", posY= " + getPosY() + ", rayon=" + getGrand_rayon() + "]";
    }

    public double getRayon() {
        return getGrand_rayon();
    }

}
