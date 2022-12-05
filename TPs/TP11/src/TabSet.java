import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.RunElement;

class TabSet<E> implements Iterable<E> {

    private E[] tableau;

    @SuppressWarnings("unchecked")
    public TabSet(int n) {
        tableau = (E[]) new Object[n];
    }

    @Override
    public TabIter iterator() {
        return null;
    }

    private class TabIter implements Iterator<E> {

        private int index;

        @Override
        public boolean hasNext() {
            if (index >= tableau.length)
                return false;

            // On parcourt le tableau à partir de la position courante jusqu'à la fin du
            // tableau
            for (int i = index; i < tableau.length; i++) {
                // Si on rencontre un élément null, cela signifie qu'il n'y a plus d'éléments à
                // parcourir
                if (tableau[i] == null)
                    return false;
            }
            // Si on a parcouru tout le tableau et qu'on n'a pas trouvé d'élément null, cela
            // signifie qu'il y a encore des éléments à parcourir
            return true;
        }

        private int findNextIndex() {
            // On parcourt le tableau à partir de la position courante jusqu'à la fin du
            // tableau
            for (int i = index; i < tableau.length; i++) {
                // Si on rencontre un élément non null, on renvoie son index
                if (tableau[i] != null)
                    return i;
            }
            // Si on a parcouru tout le tableau et qu'on n'a pas trouvé d'élément non null,
            // cela signifie qu'il n'y a plus d'éléments à parcourir
            return -1;
        }

        @Override
        public E next() {
            int lastIndex = index;
            int nextIndex = findNextIndex();

            if (nextIndex == -1)
                throw new IllegalStateException();

            index = nextIndex;
            return tableau[lastIndex];
        }
    }

    public boolean contains(Object o) {
        for (E e : tableau) {
            if (e.equals(o))
                return true;
        }
        return false;
    }

    int size() {
        int count = 0;

        for (E e : tableau) {
            if (e != null) {
                count++;
            }
        }

        return count;
    }

    boolean isEmpty() {
        return size() == 0;
    }

}