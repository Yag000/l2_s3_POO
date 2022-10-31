public class BandeDessinee extends Livre {
    private final String dessinateur;

    public BandeDessinee(String titre, String auteur, int ngPages, String dessinateur) {
        super(titre, auteur, ngPages);
        this.dessinateur = dessinateur;
    }

    @Override
    public String toString() {
        return super.toString() + ", BandeDessinee dessinateur= " + dessinateur;
    }

    @Override
    public int ordreMedia() {
        return 5;
    }
}
