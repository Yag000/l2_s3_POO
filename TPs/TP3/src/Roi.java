public class Roi extends Piece {

    public Roi(boolean couleur) {
        super(couleur, "roi");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p) && d.dist() == 1
                && (p.getCase(d.getX1(), d.getY1()).estVide()
                        || p.getCase(d.getX1(), d.getY1()).getPiece().couleur != this.couleur);
    }

    @Override
    public boolean estRoi() {
        return true;
    }

}
