import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class TabSet<E> implements Iterable<E>, Set<E> {

    private E[] tableau;

    /**
     * Constructeur prenant en paramètre la capacité initiale du {@code TabSet}.
     * 
     * @param n la capacité initiale du {@code TabSet}
     */
    @SuppressWarnings("unchecked")
    public TabSet() {
        tableau = (E[]) new Object[10];
    }

    @Override
    public TabIter iterator() {
        return new TabIter();
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

    /**
     * Cherche la premiere case vide du tableau.
     *
     * @return l'index de la premiere case vide du tableau, ou {@code -1} si le
     *         tableau est plein.
     */
    private int findIndex() {
        int counter = 0;

        for (E element : tableau) {
            if (element == null)
                return counter;

            counter++;
        }

        return -1;
    }

    @Override
    public boolean add(E e) {
        // Si l'élément est déjà présent dans le tableau, on ne l'ajoute pas
        if (contains(e))
            return false;

        // On cherche la première case vide du tableau
        int pos = findIndex();

        // Si le tableau est plein, on le redimensionne
        if (pos == -1) {
            int length = tableau.length;
            resize();
            pos = length;
        }

        // On ajoute l'élément à la première case vide du tableau
        tableau[pos] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // On parcourt le TabSet avec un itérateur et si on trouve l'élément à
        // supprimer, on le supprime avec la méthode remove et on renvoie true

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
        // On parcourt le TabSet avec un itérateur et on supprime tous les
        // éléments avec la méthode remove
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
            if (remove(e)) {
                wasModified = true;
            }
        }
        return wasModified;
    }

    /**
     * Affiche tous les éléments de la collection sur la sortie standard.
     */
    public void affiche() {
        for (E e : this) {
            System.out.println(e);
        }
    }

    /**
     * Affiche tous les éléments de la collection et les éléments nuls sur la sortie
     * standard.
     */
    public void afficheAll() {
        for (E e : tableau) {
            System.out.println(e);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] tab = new Object[size()];
        int i = 0;
        for (E e : this) {
            tab[i++] = e;
        }
        return tab;
    }

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

    /**
     * Redimensionne le tableau interne de la collection pour qu'il puisse contenir
     * deux fois plus d'éléments.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) new Object[tableau.length * 2];
        int i = 0;
        for (E e : tableau) {
            newArray[i++] = e;
        }
        tableau = newArray;
    }

    /**
     * Classe privée permettant d'itérer sur les éléments du {@code TabSet}.
     */
    private class TabIter implements Iterator<E> {

        private int index;

        /**
         * Initialise l'index de l'itérateur à 0.
         */
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

        /**
         * Cherche l'index du prochain élément non null dans le tableau.
         *
         * @return l'index du prochain élément non null dans le tableau, ou la taille du
         *         tableau si aucun
         *         élément non null n'est trouvé.
         */
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

        /**
         * Cherche l'index du dernier élément non null dans le tableau.
         *
         * @return l'index du dernier élément non null dans le tableau, ou {@code -1} si
         *         aucun élément non null n'est trouvé.
         */
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
