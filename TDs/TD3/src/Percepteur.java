public class Percepteur extends Personne {

    protected Societe societe;

    public Percepteur(int n) {
        super("fdp");
        this.societe = new Societe(n);
    }

    @Override
    public String toString() {
        return super.toString() + "Je suis un percepteur";
    }

    public void impot() {
        for (Personne p : societe.getSociete())
            if (p instanceof Roturier) {
                if (p.donnerArgent(1))
                    this.rerecevoirArgent(1);
            }
    }

}
