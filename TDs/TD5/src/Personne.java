public class Personne implements Cloneable {

    protected String nom;
    protected int argent;
    protected int pdv; // les points de vie de la personne

    public Personne(String nom, int argent, int pdv) {
        this.nom = nom;
        this.argent = argent;
        this.pdv = pdv;
    }

    public Personne(Personne p) {
        this(p.nom, p.argent, p.pdv);
    }

    public int getArgent() {
        return argent;
    }

    public void gain(int n) {
        this.argent += n;
    }

    public void tuer() {
        this.pdv = 0;
        System.out.println(this + " est mort.");
    }

    public boolean perte(int n) {
        if (n <= this.argent) {
            this.argent -= n;
            return true;
        } else {
            return false;
        }
    }

    public void blessure(int n) {
        if (this.pdv <= n) {
            this.pdv = 0;
            System.out.println(this + " est mort.");
        } else
            this.pdv -= n;
    }

    public void attaque(Personne p) {
        p.blessure(0);
    }

    public void attaque(Personne p, int degats) {
        p.blessure(degats);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Personne(nom, argent, pdv);
    }

    public String toString() {
        return "Je m'appelle " + this.nom + ". J'ai "
                + this.argent + " unités monétaires, et "
                + this.pdv + " points de vie.";
    }
}