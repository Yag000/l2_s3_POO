public class Dame extends Piece {

    public Dame(boolean couleur) {
        super(couleur, "dame");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p) && (d.distX() == d.distY() || d.distX() == 0 || d.distY() == 0)
                && p.intermVides(d);
    }

    @Override
    public boolean estRoi() {
        return false;
    }

}
