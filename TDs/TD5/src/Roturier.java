public class Roturier extends Personne {

    public Roturier(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    public Roturier(Personne p) {
        super(p);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Roturier) super.clone();
    }

}
