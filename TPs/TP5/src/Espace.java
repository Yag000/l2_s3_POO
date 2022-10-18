public class Espace extends ChaineCar {

    private int size = 1;

    public int len() {
        return size;
    }

    @Override
    public String toString() {
        return " ".repeat(size);
    }

    public void setSize(int size) {
        this.size = size;
    }

}
