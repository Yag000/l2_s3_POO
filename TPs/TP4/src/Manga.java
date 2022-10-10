public class Manga extends BandeDessinee {
    private final boolean sensInverse;

    public Manga(String titre, String auteur, int ngPages, String dessinateur, boolean sensInverse) {
        super(titre, auteur, ngPages, dessinateur);
        this.sensInverse = sensInverse;
    }

    @Override
    public String toString() {
        return super.toString() + ", Manga sensInverse=" + sensInverse;
    }

    @Override
    public int ordreMedia() {
        return 6;
    }

}
