public class Personne {
    private String nom;
    private String prenom;
    public int age;
    private int monnaie; 

    public Personne(String nom, String prenom, int age, int monnaie){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.monnaie = monnaie;
    }
    public void setPrenom(String p){
        this.prenom = p;
    }
    public void anniversaire(){
        this.age ++;
    }
    public String toString(){
        return "Je m'appelle : " + this.prenom
    + " " + this.nom + ". J'ai " + this.age + " ans." +
    "J'ai " + this.monnaie + " pieces."
    ;
    }


    public static boolean donne (Personne p1,Personne p2, int montant) {
        if (p1.monnaie >= montant){
            p1.monnaie -= montant;
            p2.monnaie += montant;
            return true;
        } 

        return false;
    }

    public boolean donne(Personne p, int montant){
        if (this.monnaie >= montant){
            this.monnaie -= montant;
            p.monnaie += montant;
            return true;
        } 

        return false;

    }
}
