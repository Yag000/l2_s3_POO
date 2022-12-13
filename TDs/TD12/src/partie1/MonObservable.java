package partie1;

import java.util.ArrayList;
import java.util.List;

public class MonObservable {

    private boolean changed = false;
    private List<MonObserver> observers = new ArrayList<>();

    MonObservable() {
    }

    void addObserver(MonObserver o) {
        observers.add(o);
    }

    void setChanged() {
        changed = true;
    }

    boolean hasChanged() {
        return changed;
    }

    void clearChanged() {
        changed = false;
    }

    void notifyObservers(Object arg) {
        if (!hasChanged())
            return;
        observers.forEach(o -> o.update(this, arg));
        clearChanged();
    }

}
