import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class TabSet<E> implements Iterable<E>, Set<E> {

    private E[] tableau;

    /**
     * Constructeur prenant en paramètre la capacité initiale du TabSet
     * 
     * @param n la capacité initiale du TabSet
     */
    @SuppressWarnings("unchecked")
    public TabSet(int n) {
        tableau = (E[]) new Object[n];
    }

    /**
     * Renvoie un itérateur permettant de parcourir les éléments du TabSet
     * 
     * @return un itérateur pour parcourir les éléments du TabSet
     */
    @Override
    public TabIter iterator() {
        return new TabIter();
    }

    /**
     * Renvoie true si l'élément passé en paramètre est présent dans le TabSet,
     * false
     * sinon
     * 
     * @param o l'élément dont on veut savoir s'il est présent dans le TabSet
     * @return true si l'élément est présent dans le TabSet, false sinon
     */
    @Override
    public boolean contains(Object o) {
        for (E e : this) {
            if (e.equals(o))
                return true;
        }
        return false;
    }

    /**
     * Renvoie la taille du TabSet, c'est-à-dire le nombre d'éléments qu'il contient
     * 
     * @return la taille du TabSet
     */
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
        int counter = 0;

        for (E element : tableau) {
            if (element == null)
                return counter;

            counter++;
        }

        return -1;
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
            it.next();
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

    public void affiche() {
        for (E e : tableau) {
            System.out.println(e);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] tab = new Object[size()];
        int i = 0;
        for (E e : this) {
            tab[i] = e;
            i++;
        }
        return tab;
    }

    /**
     * Remplit le tableau passé en paramètre avec les éléments du TabSet, et met
     * null ensuite s'il y a suffisamment de place dans le tableau. Si le tableau
     * n'est pas assez grand, un nouveau tableau de même type que a est créé et
     * renvoyé.
     * 
     * @param a le tableau à remplir avec les éléments du {@code TabSet}
     * @return le tableau rempli avec les éléments du {@code TabSet}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // Récupération du type des éléments du tableau passé en paramètre
        Class<?> c = a.getClass().getComponentType();

        // Création d'un nouveau tableau de type T[] qui contiendra les éléments du
        // TabSet

        T[] newArray = (T[]) Array.newInstance(c, size());

        // Copie des éléments du TabSet dans le nouveau tableau
        int index = 0;
        for (E e : this) {
            newArray[index++] = (T) e;
        }

        // Si le nouveau tableau est assez grand, on le remplit avec les éléments
        // du TabSet et on retourne a
        if (newArray.length <= a.length) {
            int i = 0;
            for (T t : newArray) {
                a[i++] = t;
            }
            return a;
        }
        // Sinon, on retourne le nouveau tableau
        else
            return newArray;
    }

    private class TabIter implements Iterator<E> {

        private int index;

        public TabIter() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            if (index >= tableau.length)
                return false;

            // On parcourt le tableau à partir de la position courante jusqu'à la fin du
            // tableau
            for (int i = index; i < tableau.length; i++) {
                // Si on rencontre un élément null, cela signifie qu'il n'y a plus d'éléments à
                // parcourir
                if (tableau[i] != null)
                    return true;
            }
            // Si on a parcouru tout le tableau et qu'on n'a pas trouvé d'élément null, cela
            // signifie qu'il y a encore des éléments à parcourir
            return false;
        }

        private int findNextIndex() {
            // On parcourt le tableau à partir de la position courante jusqu'à la fin du
            // tableau
            for (int i = index + 1; i < tableau.length; i++) {
                // Si on rencontre un élément non null, on renvoie son index
                if (tableau[i] != null)
                    return i;
            }
            // Si on a parcouru tout le tableau et qu'on n'a pas trouvé d'élément non null,
            // cela signifie qu'il n'y a plus d'éléments à parcourir
            return tableau.length;
        }

        @Override
        public E next() {
            if (hasNext()) {
                int lastIndex = index;
                index = findNextIndex();

                return tableau[lastIndex];
            } else {
                throw new IllegalStateException();
            }
        }

        private int findLastIndex() {

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

            int lastIndex = findLastIndex();

            if (lastIndex != -1)
                tableau[lastIndex] = null;
        }
    }

}