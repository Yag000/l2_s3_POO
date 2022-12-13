package partie1;

import java.util.ArrayList;
import java.util.List;

public class ChangePseudoHistory<T> {
    List<Pair<T>> history;

    public ChangePseudoHistory() {
        history = new ArrayList<>();
    }

    public void add(Pair<T> pseudo) {
        history.add(pseudo);
    }

    public void printHistory() {

        for (Pair<T> pseudo : history) {
            System.out.println(pseudo);
        }
    }

    public void followHistory(List<Pseudo<T>> pseudos) {
        pseudos.forEach(pseudo -> {
            pseudo.setHistory(this);
        });
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
