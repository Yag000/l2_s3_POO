public class Case {
    private boolean couleur;
    private Piece piece;


    public Case(boolean couleur, Piece piece) {
        this.couleur = couleur;
        this.piece = piece;
    }



    public Case(boolean couleur) {
        this.couleur = couleur;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean estVide(){
        return this.piece == null;
    }

    public void remplirPiece(Piece piece) {
        this.piece = piece;
    }

    public void enleverPiece(){
        this.piece = null;
    }

    public String toString() {
        if (this.piece == null) return this.couleur ? "." : "#";
        return this.piece.toString().substring(0,1);
    }


    
    
}
