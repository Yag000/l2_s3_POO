public class Pion extends Piece{

    public Pion(boolean couleur) {
        super(couleur, "pion");
    }

  /**
   * Si la pièce avance d'une case ou de deux cases lors de son premier coup, alors le coup est valide
   * 
   * @param d le coup à vérifier
   * @param p le tableau
   * @return La méthode renvoie une valeur booléenne.
   */
  
    @Override
    public boolean estValide(Deplacement d, Plateau p){
        if (!super.estValide(d, p)) return false;

        if (!d.movesForward(this.couleur)) return false;

        if(d.distY() == 1 && d.distX() == 0) return true;

        if(d.distY() == 2 && d.distX() == 0 && 
            this.couleur ?   d.getY0() == p.getLongeur() - 2 :  d.getY0() == 1 &&
            p.intermVides(d)){
                return true;
            } 

        if (d.typeDeplacement() == 'd' && d.dist() == 1 && 
            p.getCase(d.getX1(), d.getY1()).getPiece().couleur != this.couleur){
                return true;
            }        

        return false;
    }
    
    @Override
    public boolean estRoi(){
        return false;
    }
}
