public class Archer extends Roturier {

    public Archer(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    @Override
    public void attaque(Personne p) {
        p.tuer();
    }

}
