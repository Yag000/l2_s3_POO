public class Dame extends Piece {

    public Dame(boolean couleur) {
        super(couleur, "dame");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p)
                && (d.typeDeplacement() == 'd' || d.typeDeplacement() == 'h' || d.typeDeplacement() == 'v')
                && p.intermVides(d);
    }

    @Override
    public boolean estRoi() {
        return false;
    }

}
