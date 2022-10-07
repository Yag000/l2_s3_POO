public class Tour extends Piece {

    public Tour(boolean couleur) {
        super(couleur, "tour");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p) &&
                (d.typeDeplacement() == 'h' || d.typeDeplacement() == 'v') &&
                p.intermVides(d);
    }

    @Override
    public boolean estRoi() {
        return false;
    }

}
