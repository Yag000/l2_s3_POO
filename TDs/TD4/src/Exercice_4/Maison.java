package Exercice_4;

public class Maison extends Batiment {

    private static double TauxB = 1.5;

    private double surfaceJardin;
    private int nbPieces;

    public Maison(String adresse, double surfaceHabitable, double surfaceJardin, int nbPieces) {
        super(adresse, surfaceHabitable);
        this.surfaceJardin = surfaceJardin;
        this.nbPieces = nbPieces;
    }

    @Override
    public double impot() {
        return super.impot() + surfaceJardin * TauxB;
    }

    public double getSurfaceJardin() {
        return surfaceJardin;
    }

    @Override
    public String toString() {
        return super.toString() + "Maison [nbPieces=" + nbPieces + ", surfaceJardin=" + surfaceJardin + "]";
    }

}
