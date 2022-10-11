package Exercice_4;

public class Batiment {

    private static double TauxA = 5.6;

    private String adresse;
    private double surfaceHabitable;

    public Batiment(String adresse, double surfaceHabitable) {
        this.adresse = adresse;
        this.surfaceHabitable = surfaceHabitable;
    }

    public double impot() {
        return surfaceHabitable * TauxA;
    }

    @Override
    public String toString() {
        return "Batiment [adresse=" + adresse + ", surfaceHabitable=" + surfaceHabitable + "]";
    }

    public double getSurfaceHabitable() {
        return surfaceHabitable;
    }

}
