package tris;

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

    @Override
    public boolean plusGrand(int i, int j) {
        return binaryToInt(tab[i]) > binaryToInt(tab[j]);
    }

    @Override
    public int taille() {
        return tab.length;
    }

    /**
     * Convertit un tableau de booléens en entier
     * 
     * @param tab
     * @return
     */
    public static int binaryToInt(boolean[] tab) {
        int res = 0;

        for (int i = 0; i < tab.length; i++)
            res += tab[tab.length - i - 1] ? 1 << i : 0;

        return res;
    }

    @Override
    public String toString() {
        String s = "TriBinaire [tab=[";

        for (boolean[] i : tab)
            s += binaryToInt(i) + ", ";

        return s.substring(0, s.length() - 2) + "]]";

    }

}
