public class Personne {
    private String name ;
    private int argent = 0;

    public Personne ( String name ) {
        this.name = name ;
    }  

    public String toString() {
        return " Je m’appelle " + this.name + " . " ;
    }

    public void rerecevoirArgent(int montant){
        if (montant >= 0) this.argent += montant;
    }

    public boolean donnerArgent(int montant){
        if (this.argent >= montant){
            this.argent-= montant;
            return true;
        } 
        return false;
    }

    public int getArgent() {
        return argent;
    }

    
}