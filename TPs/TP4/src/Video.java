public class Video extends Media {

    private final int duree;

    public Video(String titre, int duree) {
        super(titre);
        this.duree = duree;
    }

    @Override
    public String toString() {
        return super.toString() + ", Video durée= " + duree;
    }

}
