public class Horloge {
    private CompteurCyclique minutes,heures;

    public Horloge(int m, int h){
        this.minutes = new CompteurCyclique (60,m);
        this.heures = new CompteurCyclique (24,h);
    }

    public void setHeure(int h, int m){
        this.minutes.setValue(m);
        this.heures.setValue(h);
    }

    public void setHeure(int h){
        this.heures.setValue(h);
    }

    // Question 3 Nope

    public void incrementer() {
        if (this.minutes.incrementer()) this.heures.incrementer();
    }

    public String toString(){
        return this.heures+":"+this.minutes;
    }

}
