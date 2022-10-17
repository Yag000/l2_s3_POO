import java.util.LinkedList;

public class Ligne extends ChaineCar {

    LinkedList<ChaineCar> elements = new LinkedList<ChaineCar>();

    public Ligne(LinkedList<ChaineCar> elements) {
        if (elements.size() != 0)
            this.elements = elements;
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
