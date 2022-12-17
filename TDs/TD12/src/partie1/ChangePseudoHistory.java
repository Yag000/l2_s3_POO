package partie1;

import java.util.ArrayList;
import java.util.List;

public class ChangePseudoHistory<T> implements MonObserver {
    List<Pair<T>> history;

    public ChangePseudoHistory() {
        history = new ArrayList<>();
    }

    private void add(Pair<T> pseudo) {
        history.add(pseudo);
    }

    public void printHistory() {
        for (Pair<T> pseudo : history) {
            System.out.println(pseudo);
        }
    }

    @Override
    public void update(MonObservable o, Object arg) {
        if (o instanceof Pseudo) {
            Pseudo<T> pseudo = (Pseudo<T>) o;
            add(new Pair<>(pseudo.get(), (T) arg));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair<T> pseudo : history) {
            sb.append(pseudo).append("\n");
        }
        return sb.toString();
    }

}
