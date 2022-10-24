package figures;

public class Ellipse extends Figure implements Deformable {
    private final double grand_rayon;
    private final double petit_rayon;

    public Ellipse(int x, int y, double grand_rayon, double petit_rayon) {
        super(x, y);
        this.grand_rayon = grand_rayon;
        this.petit_rayon = petit_rayon;
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public Figure deformation(double coeffH, double coeffV) {
        if (grand_rayon * coeffH == petit_rayon * coeffV)
            return new Cercle(getPosX(), getPosY(), grand_rayon * coeffV);
        else
            return new Ellipse(getPosX(), getPosY(), grand_rayon * coeffH, petit_rayon * coeffV);
    }

    @Override
    public String toString() {
        return "Ellipse [posX= " + getPosX() + "posY= " + getPosY() + ", grand_rayon=" + grand_rayon + ", petit_rayon="
                + petit_rayon + "]";
    }

    public double getGrand_rayon() {
        return grand_rayon;
    }

    public double getPetit_rayon() {
        return petit_rayon;
    }

    @Override
    public double surface() {
        return Math.PI * petit_rayon * grand_rayon;
    }

}