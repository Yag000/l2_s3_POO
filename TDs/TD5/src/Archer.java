public class Archer extends Roturier {

    public Archer(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Archer) super.clone();
    }

    @Override
    public void attaque(Personne p) {
        p.tuer();
    }

}
