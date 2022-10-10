class Piece {

    protected boolean couleur;
    protected String nom;

    public Piece(boolean couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public boolean getCouleur() {
        return this.couleur;
    }

    public String toString() {
        if (couleur)
            return nom.substring(0, 1).toLowerCase() + nom.substring(1);
        return nom.substring(0, 1).toUpperCase() + nom.substring(1);
    }

    /**
     * La fonction retourne vrai si le coup est valide, faux sinon
     * 
     * @param d le coup à vérifier
     * @param p le tableau
     * @return Une valeur booléenne.
     */
    public boolean estValide(Deplacement d, Plateau p) {
        return p.horsLimite(d) &&
                (p.getCase(d.getX1(), d.getY1()).estVide()
                        || p.getCase(d.getX1(), d.getY1()).getPiece().couleur != this.couleur);
    }

    /**
     * Cette fonction renvoie true si la pièce est un roi, et false sinon.
     * 
     * @return La valeur booléenne de l'instruction.
     */
    public boolean estRoi() {
        return this.nom.equals("Roi");
    }

}