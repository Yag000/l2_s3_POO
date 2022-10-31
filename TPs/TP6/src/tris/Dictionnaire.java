package tris;

import java.util.Arrays;

public class Dictionnaire implements Triable {

    private String[] tab;

    public Dictionnaire(String[] tab) {
        this.tab = tab;
    }

    @Override
    public void echange(int i, int j) {
        String tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    @Override
    public boolean plusGrand(int i, int j) {
        return tab[i].toLowerCase().compareTo(tab[j].toLowerCase()) > 0;
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public String toString() {
        return "Dictionnaire [tab=" + Arrays.toString(tab) + "]";
    }

}
