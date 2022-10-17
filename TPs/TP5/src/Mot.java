
public class Mot extends ChaineCar {

    private String s;

    public Mot(String s) {
        this.s = s;
    }

    public int len() {
        return s.length();
    }

    @Override
    public String toString() {
        return s;
    }

}
