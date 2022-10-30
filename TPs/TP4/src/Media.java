public class Media {

    private final String titre;
    private static int numeroElements = 0;
    private final int id;

    {
        id = numeroElements++;
    }

    public Media(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public int getNumero() {
        return id;
    }

    /*
     * public boolean plusPetit(Media doc) {
     * return id < doc.id;
     * }
     * 
     * public boolean plusPetit(Livre doc) {
     * if (this instanceof Livre)
     * return id < doc.getNumero();
     * return false;
     * }
     */

    public boolean plusPetit(Media doc) {
        if (this.ordreMedia() == doc.ordreMedia())
            return id < doc.getNumero();
        return this.ordreMedia() < doc.ordreMedia();
    }

    public int ordreMedia() {
        return 0;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titre=" + titre;
    }

}
