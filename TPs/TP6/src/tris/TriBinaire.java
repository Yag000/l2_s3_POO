package tris;

import java.util.Arrays;

//TODO: add test

public class TriBinaire implements Triable {
    private boolean[][] tab;

    public TriBinaire(boolean[][] tab) {
        this.tab = tab;
    }

    @Override
    public void echange(int i, int j) {
        boolean[] tmp = tab[i].clone();
        tab[i] = tab[j].clone();
        tab[j] = tmp;
    }

    // TODO. make prettier
    @Override
    public boolean plusGrand(int i, int j) {
        int firstIndexI = 0;

        for (int k = 0; k < tab[i].length; k++)
            if (tab[i][k]) {
                firstIndexI = k;
                break;
            }

        int firstIndexJ = 0;

        for (int k = 0; k < tab[j].length; k++)
            if (tab[j][k]) {
                firstIndexI = k;
                break;
            }

        for (int k = 0; k < tab[i].length - firstIndexI && k < tab[j].length - firstIndexJ; k++) {
            if (tab[i][firstIndexI + k] && !tab[j][firstIndexJ + k])
                return true;
            if (!tab[i][firstIndexI + k] && tab[j][firstIndexJ + k])
                return false;

        }

        return tab[i].length - firstIndexI - (tab[j].length - firstIndexJ) > 0;
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public String toString() {
        return "TriBinaire [tab=" + Arrays.toString(tab) + "]";
    }

}
