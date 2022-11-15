package Exo_5;

interface BoiteAEntiers {
    int lire(int index);

    void ajouter(int valeur);

    void vider();

    int nombreDElements();

    default void inserer(int index, int valeur) {
        throw new UnsupportedOperationException(" La méthode inserer n'est pas définie.");
    }

    default int retirer(int index) {
        throw new UnsupportedOperationException(" La méthode retirer n'est pas définie.");
    }

}