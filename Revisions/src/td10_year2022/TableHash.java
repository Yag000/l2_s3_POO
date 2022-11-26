package td10_year2022;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface TableHash {

    int size();

    Object searchVal(Object key) throws ClefAbsentException;

    void insert(Object key, Object val) throws ClefPresentException;

    void remove(Object key, Predicate<Object> p);

    default void remove(Object key) {
        remove(key, x -> true);
    }

    List<Entree> sort(Comparator<Object> clefComp);

    public static class Entree {
        private final Object clef;
        private final Object val;

        public Entree(Object clef, Object val) {
            this.clef = clef;
            this.val = val;
        }

        public Object getClef() {
            return clef;
        }

        public Object getVal() {
            return val;
        }

        @Override
        public String toString() {
            return clef + " -> " + val;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (o == null)
                return false;

            if (getClass() != o.getClass())
                return false;

            Entree a = (Entree) o;

            return clef.equals(a.clef);
        }

        @Override
        public int hashCode() {
            return clef.hashCode();
        }

    }

    public class ClefAbsentException extends RuntimeException {

        public ClefAbsentException() {
            super();
        }

        public ClefAbsentException(String key) {
            super("There is not such key in the table: " + key);
        }
    }

    public class ClefPresentException extends RuntimeException {

        public ClefPresentException() {
            super();
        }

        public ClefPresentException(String key) {
            super("There is already such key in the table: " + key);
        }
    }
}
