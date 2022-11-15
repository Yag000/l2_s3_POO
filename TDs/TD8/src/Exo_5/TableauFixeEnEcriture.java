package Exo_5;

public class TableauFixeEnEcriture implements BoiteAEntiers {

    private int[] tab;

    public TableauFixeEnEcriture(int[] tab) {
        this.tab = tab.clone();
    }

    @Override
    public int lire(int index) throws LectureEcritureException {
        throw new LectureEcritureException();
    }

    @Override
    public void ajouter(int valeur) {
        tab[tab.length - 1] = valeur;
    }

    @Override
    public void vider() throws EcritureInterditeException {
        for (int i = 0; i < tab.length; i++)
            tab[i] = 0;
    }

    @Override
    public int nombreDElements() throws LectureEcritureException {
        throw new LectureEcritureException();
    }
}
