package figures;

public class Rectangle extends Figure implements Deformable {
    private final double largeur;
    private final double hauteur;

    public Rectangle(int x, int y, double largeur, double hauteur) {
        super(x, y);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return "Rectangle [posX= " + getPosX() + "posY= " + getPosY() + ", largeur=" + largeur + ", hauteur=" + hauteur
                + "]";
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public Figure deformation(double coeffH, double coeffV) {
        if (largeur * coeffH == hauteur * coeffV)
            return new Carre(getPosX(), getPosY(), hauteur * coeffV);
        else
            return new Rectangle(getPosX(), getPosY(), largeur * coeffH, hauteur * coeffV);
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public double surface() {
        return largeur * hauteur;
    }

}
