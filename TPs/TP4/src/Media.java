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

    public boolean plusPetit(Media doc) {
        return id < doc.id;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titre=" + titre;
    }

}
