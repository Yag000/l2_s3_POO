package tris;

import javax.swing.event.DocumentEvent.ElementChange;

public interface Triable {
    // échange les éléments en positions i et j
    void echange(int i, int j);

    // retourne vrai si l’élément de position i est plus grand que
    // l’élément de position j
    boolean plusGrand(int i, int j);

    // nombre d’éléments à trier
    int taille();

    static void triBulles(Triable tab) {
        boolean change = false;
        do {
            change = false;
            for (int i = 0; i < tab.taille() - 1; i++) {
                if (tab.plusGrand(i, i + 1)) {
                    tab.echange(i, i + 1);
                    change = true;
                }
            }
        } while (change);
    }
}