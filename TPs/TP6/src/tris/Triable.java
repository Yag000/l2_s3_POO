package tris;

/**
 * Interface pour les objets triables
 */
public interface Triable {
    /**
     * Echange les éléments d'indice i et j
     * 
     * @param i
     * @param j
     */
    void echange(int i, int j);

    /**
     * @param i
     * @param j
     * @return true si l'élément en position i est plus grand que l'élément en
     *         position j
     */
    boolean plusGrand(int i, int j);

    /**
     * @return nombre d'éléments a trier
     */
    int taille();

    /**
     * Trie le tableau en utilisant l'algorithme de tri à bulles
     */
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
