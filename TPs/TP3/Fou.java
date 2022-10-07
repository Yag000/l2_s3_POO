public class Fou extends Piece {

    public Fou(boolean couleur) {
        super(couleur, "fou");
    }
    
    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        return super.estValide(d, p) && d.typeDeplacement() == 'd' && p.intermVides(d);
    }
    
    @Override
    public boolean estRoi(){
        return false;
    }
}
