package Exercice_3;

public class Plante {
    private static int nbPlanteSoif;
    private boolean arrosse = false;

    public Plante() {
        nbPlanteSoif++;
    }

    public static int etat() {
        return nbPlanteSoif;
    }

    public static void arrosage(Plante p) {
        if (!p.arrosse) {
            nbPlanteSoif--;
            p.arrosse = true;
        }
        if (p instanceof PlanteFleurie) {
            PlanteFleurie.arrosage((PlanteFleurie) p);
        }
    }

    /*
     * public static void arrosage() {
     * nbPlanteSoif--;
     * }
     * 
     * public static void arrosage() {
     * nbPlanteSoif--;
     * PlanteFleurie.arrosage();
     * }
     */

    @Override
    public String toString() {
        return "Plante [arrosse=" + arrosse + "]";
    }

}