public class LongMetrage extends Video {
    private final String realisateur;

    public LongMetrage(String titre, int duree, String realisateur) {
        super(titre, duree);
        this.realisateur = realisateur;
    }

    @Override
    public String toString() {
        return super.toString() + ", LongMetrage realisateur= " + realisateur;
    }

}
