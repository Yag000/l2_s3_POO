public class PercepteurInegalitaire extends Percepteur{

    public PercepteurInegalitaire(int n) {
        super(n);
    }

    @Override
    public void impot() {
        for (Personne p: societe.getSociete()){
            if (p instanceof Roturier){
                int impot = 0;
                if (p instanceof Bourgeois) impot = 3 * p.getArgent()/4;
                else if (p instanceof Artisans)  impot = p.getArgent()/2;
                else if (p instanceof Paysan)  impot = p.getArgent()/4;
                if (p.donnerArgent(impot)) 
                    this.rerecevoirArgent(impot);
            }
        }

    }
    
}
