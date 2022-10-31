public class Livre extends Media {

    private final String auteur;
    private final int ngPages;

    public Livre(String titre, String auteur, int ngPages) {
        super(titre);
        this.auteur = auteur;
        this.ngPages = ngPages;
    }

    @Override
    public String toString() {
        return super.toString() + ", Livre auteur= " + auteur + ", ngPages= " + ngPages;
    }


    /*
     * @Override
     * public boolean plusPetit(Media doc) {
     * if (doc instanceof Livre)
     * return super.plusPetit(doc);
     * return false;
     * }
     */

    @Override
    public int ordreMedia() {
        return 4;
    }

}
