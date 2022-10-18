public class Espace extends ChaineCar {

    private int size = 1;

    public Espace(int size) {
        this.size = size;
    }

    public Espace() {
    }

    public int len() {
        return size;
    }

    public void addOneSpace() {
        size++;
    }

    public void addSpaces(int n) {
        size += n;
    }

    @Override
    public String toString() {
        return " ".repeat(size);
    }

    public void setSize(int size) {
        this.size = size;
    }

}
