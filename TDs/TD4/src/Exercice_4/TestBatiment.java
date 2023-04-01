package Exercice_4;

public class TestBatiment {

    public double surfaceHabitableTotale(Batiment[] tabBat) {
        double total = 0.;
        for (Batiment b : tabBat)
            if (b != null)
                total += b.getSurfaceHabitable();

        return total;
    }

    public double surfaceJardinTotale(Batiment[] tabBat) {
        double total = 0.;
        for (Batiment b : tabBat)
            if (b != null && b instanceof Maison)
                total += ((Maison) b).getSurfaceJardin();

        return total;
    }

    public static void main(String[] args) {

    }
}
