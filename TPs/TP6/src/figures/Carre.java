package figures;

public class Carre extends Rectangle {

    public Carre(int x, int y, double longeur) {
        super(x, y, longeur, longeur);
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Carre [posX= " + getPosX() + ", posY= " + getPosY() + ", longueur=" + getLargeur() + "]";
    }

    /**
     * @return the longueur
     */
    public double getLongueur() {
        return getLargeur();
    }

}
