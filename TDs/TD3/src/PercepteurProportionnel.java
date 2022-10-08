public class PercepteurProportionnel extends Percepteur{

    public PercepteurProportionnel(int n) {
        super(n);
    }

    @Override
    public void impot(){
        for (Personne p: societe.getSociete()) 
            if (p instanceof Roturier){
                int impot = p.getArgent()/2;
                if (p.donnerArgent(impot)) 
                    this.rerecevoirArgent(impot);
            }
    }

    
    
}
