public class Cercle extends Ellipse {

    public Cercle(int x, int y, double rayon) {
        super(x, y, rayon, rayon);
    }

    @Override
    public void affiche() {
        // TODO Auto-generated method stub
        super.affiche();
    }

    @Override
    public String toString() {
        return "Cercle [posX= " + getPosX() + "posY= " + getPosY() + ", rayon=" + getGrand_rayon() + "]";
    }

}
