public class Societe {
    private Personne[] societe;

    public Societe(int n) {

        this.societe = new Personne[n];

        for (int i = 0;i < n; i++){
            switch((int) (Math.random()*5)){
                case 0: societe[i] = new Noble("Personne_" +i); break;
                case 1: societe[i] = new Bourgeois("Personne_" +i); break;
                case 2: societe[i] = new Paysan("Personne_" +i); break;
                case 3: societe[i] = new Artisans("Personne_" +i); break;
                case 4: societe[i] = new Pretre("Personne_" +i); break;
            }
        }
    }

    public int nbPaysans(){
        int nb = 0;
        for (Personne p: societe) if (p instanceof Paysan) nb++;
        return nb;
    }

    public int argentTotal(){
        int total = 0;
        for (Personne p: societe) if (p instanceof Roturier) total+=p.getArgent();
        return total;
    }

    public void afficher(){
        for (Personne p: societe) System.out.println(p);
    }
    

    public static void main(String[] args) {
        Societe test = new Societe(10);
        test.afficher();
        System.out.println(test.nbPaysans());

        Societe test2 = new Societe(1000);
        System.out.println(test2.nbPaysans());


    }

    public Personne[] getSociete() {
        return societe;
    }
}
