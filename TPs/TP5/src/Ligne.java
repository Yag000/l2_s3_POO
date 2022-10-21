import java.util.LinkedList;

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

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public void addChaine(ChaineCar c) {
        elements.add(c);
    }

    public int countSpaces() {
        int nb = 0;
        for (ChaineCar c : elements)
            if (c instanceof Espace)
                if (elements.getLast() != (ChaineCar) c)
                    nb++;

        return nb;
    }

    public void removeLastSpace() {
        if (elements.size() > 0 && elements.getLast() instanceof Espace)
            elements.removeLast();
    }

    public void justifier(int longeur) {
        if (longeur == 0)
            return;
        if (elements == null)
            return;

        int numberOfSpaces = countSpaces();

        if (numberOfSpaces == 0) {
            addChaine(new Espace(longeur));
            return;
        }

        int minNumber = longeur / numberOfSpaces;
        int extra = longeur % numberOfSpaces;

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

    public boolean isOnlySpaces() {
        for (ChaineCar c : elements)
            if (c instanceof Mot)
                return false;
        return true;
    }

}
