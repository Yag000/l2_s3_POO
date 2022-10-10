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

    public static void main(String[] args) {
        Media m = new Media("ta mere");
        Media m2 = new Media("ta mere");
        Media m3 = new Media("ta mere");
        Media m4 = new Media("ta mere");

        System.out.println(m.getNumero());
        System.out.println(m2.getNumero());
        System.out.println(m3.getNumero());
        System.out.println(m4.getNumero());

    }

}
