package Exercice_3;

public class PlanteFleurie extends Plante {
    private static int nbPlanteSansEngrais;
    private boolean engrais = false;

    public PlanteFleurie() {
        nbPlanteSansEngrais++;
    }

    public static int etat() {
        return nbPlanteSansEngrais;
    }

    public static void arrosage(PlanteFleurie p) {
        if (!p.engrais) {
            nbPlanteSansEngrais--;
            p.engrais = true;
        }
    }

    @Override
    public String toString() {
        return "PlanteFleurie [engrais=" + engrais + "]";
    }

    public static void main(String[] args) {

    }

}
