public class Informations {

    /*
     * Classe qui contient trois attributs,
     * vitalite, force et agilite, des personnages.
     * La clsse contient les getters et setters apporpiés.
     */

    private int vitalite, force, agilite;

    public Informations(int v, int f, int a){
        this.vitalite = v;
        this.force = f;
        this.agilite = a;

    }

    public Informations(Informations f){
        this(f.vitalite,f.force,f.agilite);
    }

    public int getVitalite(){ return this.vitalite;}
    public int getForce(){ return this.force;}
    public int getAgilite(){ return this.agilite;}

    // On considere que la vitalité est toujours superieur ou egale a 0(ce qui signifie la por du personnage)
    public void setVitalite(int v){this.vitalite = Math.max(0,v);} 
    public void setForce(int f){this.force = f;}
    public void setAgilite(int a){this.agilite = a;}

    public String toString(){return this.vitalite + "/" + this.force + "/" + this.agilite;}

}
