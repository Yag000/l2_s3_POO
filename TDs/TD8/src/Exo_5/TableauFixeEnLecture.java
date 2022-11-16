package Exo_5;

public class TableauFixeEnLecture implements BoiteAEntiers {

    private int[] tab;

    public TableauFixeEnLecture(int[] tab) {
        this.tab = tab.clone();
    }

    @Override
    public int lire(int index) {
        return tab[index];
    }

    @Override
    public void ajouter(int valeur) throws EcritureInterditeException {
        throw new EcritureInterditeException();
    }

    @Override
    public void vider() throws EcritureInterditeException {
        throw new EcritureInterditeException();

    }

    @Override
    public int nombreDElements() {
        return tab.length;
    }

}
