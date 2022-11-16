public class Chevalier extends Noble {

    private Personne geolier = null;
    private static final int prixLiberté = 50;

    public Chevalier(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    @Override
    public void attaque(Personne p) {
        if (p instanceof Chevalier)
            ((Chevalier) p).setGeolier(this);
    }

    public boolean acheteLiberte() {
        if (getArgent() > prixLiberté) {
            this.geolier.gain(prixLiberté);
            perte(prixLiberté);
            geolier = null;
            return true;

        }
        return false;

    }

    public void setGeolier(Personne geolier) {
        this.geolier = geolier;
        acheteLiberte();
    }

}
