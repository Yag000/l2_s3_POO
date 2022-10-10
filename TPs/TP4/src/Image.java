public class Image extends Media {
    private final int largeur;
    private final int hauteur;

    public Image(String titre, int largeur, int hauteur) {
        super(titre);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return super.toString() + ", Image largeur= " + largeur + ", hauteur= " + hauteur;
    }

}
