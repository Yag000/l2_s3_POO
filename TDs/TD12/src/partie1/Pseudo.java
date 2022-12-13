package partie1;

import java.util.ArrayList;
import java.util.List;

public class Pseudo<T> {

    private T pseudo;
    private List<ChangePseudoHistory<T>> history = new ArrayList<>();

    public Pseudo(T pseudo) {
        this.pseudo = pseudo;
    }

    public T get() {
        return pseudo;
    }

    public void set(T pseudo) {
        history.forEach(h -> h.add(new Pair<>(this.pseudo, pseudo)));
        this.pseudo = pseudo;
    }

    public void setHistory(ChangePseudoHistory<T> history) {
        this.history.add(history);
    }

}
