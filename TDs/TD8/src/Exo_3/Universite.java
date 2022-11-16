package Exo_3;

import java.util.Random;

public class Universite {
    private int nbEtu; // nombre d’étudiants inscrits à l’université
    private int capALL; // capacité en arts, lettres, langues
    private int capSHS; // capacité en sciences humaines et sociales
    private int capSTS; // capacité en sciences, technologies et santé

    public Universite(int nbEtu, int capALL, int capSHS, int capSTS)

            throws IllegalArgumentException {
        if (nbEtu <= 0 || capALL < 0 || capSHS < 0 || capSTS < 0)
            throw new IllegalArgumentException();

        if (nbEtu > capALL + capSHS + capSTS)
            throw new IllegalArgumentException();

        this.nbEtu = nbEtu;
        this.capALL = capALL;
        this.capSHS = capSHS;
        this.capSTS = capSTS;
    }

    void restructuration(int capALL, int capSHS, int capSTS) throws DirectiveMinisterielleException {
        if (capALL + capSHS + capSTS < nbEtu)
            throw new TropPeuDCapaciteException();

        if (capALL > capSHS + capSTS) {
            throw new DirectiveMinisterielleException("capALL");
        }

        if (capSHS > capALL + capSTS) {
            throw new DirectiveMinisterielleException("capSHS");
        }

        if (capSTS > capSHS + capSHS) {
            throw new DirectiveMinisterielleException("capSTS");
        }

        this.capALL = capALL;
        this.capSHS = capSHS;
        this.capSTS = capSTS;
    }

    void restrictionBudgetaire() throws DirectiveMinisterielleException, TropPeuDCapaciteException {
        Random rd = new Random();
        int nCapALL = capALL - rd.nextInt((int) (0.5 * capALL));
        int nCapSHS = capSHS - rd.nextInt((int) (0.5 * capSHS));
        int nCapSTS = capSTS - rd.nextInt((int) (0.5 * capSTS));
        try {
            restructuration(nCapALL, nCapSHS, nCapSTS);
        } catch (TropPeuDCapaciteException e) {
            reduction(10);
        } catch (DirectiveMinisterielleException e) {
            nCapALL = capALL - rd.nextInt((int) (0.5 * capALL));
            nCapSHS = capSHS - rd.nextInt((int) (0.5 * capSHS));
            nCapSTS = capSTS - rd.nextInt((int) (0.5 * capSTS));
        } finally {
            restructuration(nCapALL, nCapSHS, nCapSTS);
        }
    }

    public void reduction(int nb) {
        nbEtu -= nb;
    }

    // Question 5: On peut rajouter un argument à l'exception de type int qui
    // represente le surplus.

}
