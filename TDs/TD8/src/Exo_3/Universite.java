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

}
