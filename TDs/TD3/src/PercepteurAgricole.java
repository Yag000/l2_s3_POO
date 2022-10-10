public class PercepteurAgricole extends Percepteur{

    public PercepteurAgricole(int n) {
        super(n);
    }

    @Override
    public void impot() {
        for (Personne p: societe.getSociete()) 
            if (p instanceof Paysan){
                    if (p.donnerArgent(1)) 
                        this.rerecevoirArgent(1);
            }
    }
        
        
    }

}
