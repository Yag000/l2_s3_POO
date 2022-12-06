import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {
    private E[] tableau;
    private int index;

    public TestIter(E[] tableau) {
        this.tableau = tableau;
    }

    @Override
    public boolean hasNext() {
        return index < tableau.length && tableau[index] != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            return tableau[index++];
        } else {
            throw new IllegalStateException();
        }
    }

}
