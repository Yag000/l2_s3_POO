public class Fantassin extends Roturier {

    private int degats;

    public Fantassin(Personne p, int degats) {
        super(p);
        this.degats = degats;
    }

    public Fantassin(String nom, int argent, int pdv, int degats) {
        super(nom, argent, pdv);
        this.degats = degats;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new fantassin();
    }

    @Override
    public void attaque(Personne p) {
        if (p instanceof Chevalier)
            ((Chevalier) p).setGeolier(this);
        else
            super.attaque(p, degats);
    }

}
