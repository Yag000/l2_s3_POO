package partie1;

import java.util.ArrayList;
import java.util.List;

public class Pseudo {

    private String pseudo;
    private List<ChangePseudoHistory> history = new ArrayList<>();

    public Pseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String get() {
        return pseudo;
    }

    public void set(String pseudo) {
        history.forEach(h -> h.add(new ChangePseudoHistory.Pair(this.pseudo, pseudo)));
        this.pseudo = pseudo;
    }

    public void setHistory(ChangePseudoHistory history) {
        this.history.add(history);
    }

}
