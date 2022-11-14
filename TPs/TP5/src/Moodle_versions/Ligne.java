import java.util.LinkedList;

/**
 * Classe qui représente une ligne
 */
public class Ligne extends ChaineCar {

    LinkedList<ChaineCar> elements = new LinkedList<ChaineCar>();

    public Ligne(ChaineCar c) {
        elements.add(c);
    }

    public Ligne() {
    }

    public int len() {
        int length = 0;

        for (ChaineCar c : elements)
            length += c.len();

        return length;
    }

    /**
     * @return true si la ligne est vide
     */
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    /**
     * Ajoute une chaîne de caractères à la liste des éléments
     * 
     * @param c Le caractère à ajouter à la chaîne.
     */
    public void addChaine(ChaineCar c) {
        elements.add(c);
    }

    /**
     * Compte le nombre d'espaces
     * 
     * @return nombre d'espaces
     */
    public int countSpaces() {
        int nb = 0;
        for (ChaineCar c : elements)
            if (c instanceof Espace)
                if (elements.getLast() != (ChaineCar) c)
                    nb++;

        return nb;
    }

    /**
     * Élimine le dernier espace l'une ligne
     */
    public void removeLastSpace() {
        if (elements.size() > 0 && elements.getLast() instanceof Espace)
            elements.removeLast();
    }

    /**
     * Justifie la ligne:
     * La fonction ajoute nbEspacesAjouter espaces a la ligne (de manière homogène
     * en
     * commençant par le premier espace)
     * 
     * @param nbEspacesAjouter
     */
    public void justifier(int nbEspacesAjouter) {
        if (nbEspacesAjouter == 0)
            return;
        if (elements == null)
            return;

        int numberOfSpaces = countSpaces();

        if (numberOfSpaces == 0) {
            addChaine(new Espace(nbEspacesAjouter));
            return;
        }

        int minNumber = nbEspacesAjouter / numberOfSpaces;
        int extra = nbEspacesAjouter % numberOfSpaces;

        int counter = 0;
        for (ChaineCar c : elements) {
            if (c instanceof Espace espace) {
                espace.addSpaces(counter < extra ? minNumber + 1 : minNumber);
                counter++;
            }
        }

    }

    @Override
    public String toString() {
        String s = "";

        if (elements != null) {
            for (ChaineCar c : elements)
                s += c;
        }
        return s;
    }
}
