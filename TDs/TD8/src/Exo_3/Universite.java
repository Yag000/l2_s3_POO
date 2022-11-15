package Exo_3;

public class Universite {
    private int nbEtu; // nombre d’étudiants inscrits à l’université
    private int capALL; // capacité en arts, lettres, langues
    private int capSHS; // capacité en sciences humaines et sociales
    private int capSTS; // capacité en sciences, technologies et santé

    public Universite(int nbEtu, int capALL, int capSHS, int capSTS)

            throws IllegalArgumentException {
        if (nbEtu <= 0 || capALL < 0 || capSHS < 0 || capSTS < 0)
            throw new IllegalArgumentException();

        if (nbEtu > capALL)
            throw new IllegalArgumentException();

        if (capALL != capSHS + capSTS)
            throw new IllegalArgumentException();

        this.nbEtu = nbEtu;
        this.capALL = capALL;
        this.capSHS = capSHS;
        this.capSTS = capSTS;
    }

}
