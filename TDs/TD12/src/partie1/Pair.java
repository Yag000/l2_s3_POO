package partie1;

public class Pair<T> {
    private T firstPseudo;
    private T secondPseudo;

    public Pair(T first, T second) {
        firstPseudo = first;
        secondPseudo = second;
    }

    public T getFirst() {
        return firstPseudo;
    }

    public T getSecond() {
        return secondPseudo;
    }

    @Override
    public String toString() {
        return firstPseudo + " -> " + secondPseudo;
    }
}
