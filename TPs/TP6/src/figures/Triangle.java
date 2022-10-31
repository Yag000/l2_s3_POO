package figures;

public class Triangle extends Figure implements Deformable {
    private final double base;
    private final double hauteur;

    public Triangle(int x, int y, double base, double hauteur) {
        super(x, y);
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    public Figure deformation(double coeffH, double coeffV) {
        return new Triangle(getPosX(), getPosY(), base * coeffH, hauteur * coeffV);
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Triangle [posX= " + getPosX() + ", posY= " + getPosY() + ", base=" + base + ", hauteur=" + hauteur
                + "]";
    }

    @Override
    public double surface() {
        return (base * hauteur) / 2;
    }

}
