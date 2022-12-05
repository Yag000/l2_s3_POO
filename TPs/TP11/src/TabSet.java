import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class TabSet<E> implements Iterable<E>, Set<E> {

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

        private int findLastIdex() {

            for (int i = index - 1; i >= 0; i--) {
                if (tableau[i] != null)
                    return i;
            }

            return -1;
        }

        @Override
        public void remove() {

            if (index == 0)
                throw new IllegalStateException();

            int lastIndex = findLastIdex();

            if (lastIndex != -1)
                tableau[lastIndex] = null;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (E e : this) {
            if (e.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;

        for (E e : this) {
            count++;
        }

        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private int findIndex(E e) {
        int pos = 0;
        int counter = 0;

        boolean full = true;

        for (E element : tableau) {

            if (element != null && element.equals(e))
                return -1;

            if (element != null && pos == 0) {
                pos = counter;
                full = false;
            }

            counter++;
        }

        return !full ? pos : -1;
    }

    public boolean add(E e) {
        if (contains(e))
            return false;

        int pos = findIndex(e);

        if (pos == -1)
            return false;

        tableau[pos] = e;
        return true;
    }

    public boolean remove(Object o) {

        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E e = it.next();
            if (e.equals(o)) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E e = it.next();
            it.remove();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e))
                return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> c) {
        boolean wasModified = false;
        for (Object e : c) {
            if (add((E) e)) {
                wasModified = true;
            }
        }
        return wasModified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean wasModified = false;
        for (E e : this) {
            if (!c.contains(e) && remove(e)) {
                wasModified = true;
            }
        }
        return wasModified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean wasModified = false;
        for (Object e : c) {
            if (remove(c)) {
                wasModified = true;
            }
        }
        return wasModified;
    }

}