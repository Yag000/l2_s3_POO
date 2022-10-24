package tris;

public class Dictionnaire implements Triable {

    private String[] tab;

    @Override
    public void echange(int i, int j) {
        String tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    @Override
    public boolean plusGrand(int i, int j) {
        return tab[i].compareTo(tab[j]) > 0;
    }

    @Override
    public int taille() {
        return tab.length;
    }

}
