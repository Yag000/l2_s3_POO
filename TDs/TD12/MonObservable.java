public class MonObservable {

    private boolean changed = false;
    private List<Observer> observers = new ArrayList<>();

    MonObservable() {
    }

    void addObserver(Observer o) {
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

    notifyObservers(Object arg){
        if (!hasChanged())
            return;
        observers.forEach(o -> o.update(this, arg));
        clearChanged();
    }

}
