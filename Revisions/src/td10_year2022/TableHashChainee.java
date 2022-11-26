package td10_year2022;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class TableHashChainee implements TableHash {

    ListeOverflow[] t;

    private class ListeOverflow extends LinkedList<Entree> {
        int searchClef(Object c) {
            return this.indexOf(new Entree(c, null));
        }
    }

    public TableHashChainee(int tailleMax) {
        t = new ListeOverflow[tailleMax];
    }

    private int computeIndex(Object key) {
        return key.hashCode() % t.length;
    }

    @Override
    public void insert(Object clef, Object val) throws ClefPresentException {
        try {
            searchVal(clef);
            throw new ClefPresentException();
        } catch (Exception e) {
        }

        t[computeIndex(clef)].addFirst(new Entree(clef, val));

    }

    @Override
    public int size() {
        int totalSum = 0;

        for (ListeOverflow list : t)
            totalSum += list.size();

        return totalSum;
    }

    @Override
    public Object searchVal(Object key) throws ClefAbsentException {
        int index = t[computeIndex(key)].searchClef(key);

        if (index == -1)
            throw new ClassCastException();

        return t[computeIndex(key)].get(index);
    }

    @Override
    public void remove(Object key, Predicate<Object> p) {
        ListeOverflow liste = t[computeIndex(key)];
        int index = liste.searchClef(key);

        if (p.test(liste.get(index).getVal()))
            liste.remove(index);
    }

    @Override
    public List<Entree> sort(Comparator<Object> clefComp) {
        List<Entree> res = new LinkedList<>();

        for (ListeOverflow list : t)
            res.addAll(list);

        res.sort((entree1, entree2) -> clefComp.compare(entree1.getClef(), entree2.getClef()));

        return res;
    }
}