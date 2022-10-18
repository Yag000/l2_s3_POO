public class Fantassin extends Roturier {

    private int degats;

    public Fantassin(String nom, int argent, int pdv, int degats) {
        super(nom, argent, pdv);
        this.degats = degats;
    }

    @Override
    public void attaque(Personne p) {
        // TODO Auto-generated method stub
        if (p instanceof Chevalier)
            ((Chevalier) p).setGeolier(this);
        else
            super.attaque(p, degats);
    }

}
