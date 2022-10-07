public class Cavalier extends Piece {

    public Cavalier(boolean couleur) {
        super(couleur, "Cavalier");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p) && (d.typeDeplacement() == 'c');
    }

    @Override
    public boolean estRoi() {
        return false;
    }
}
