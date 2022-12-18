package partie1;

public class Pseudo<T> extends MonObservable {

    private T pseudo;

    public Pseudo(T pseudo) {
        super();
        this.pseudo = pseudo;
    }

    public T get() {
        return pseudo;
    }

    public void set(T pseudo) {
        setChanged();
        notifyObservers(pseudo);
        this.pseudo = pseudo;
    }

}
