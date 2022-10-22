/**
 * Casse qui représente une chaîne d'espaces
 */

public class Espace extends ChaineCar {

    private int size = 1;

    public Espace(int size) {
        this.size = size;
    }

    public Espace() {
    }

    /**
     * Ajoute n espaces à la taille de l'objet.
     * 
     * @param n Le nombre d'espaces à ajouter.
     */
    public void addSpaces(int n) {
        size += n;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int len() {
        return size;
    }

    @Override
    public String toString() {
        return " ".repeat(size);
    }
}
