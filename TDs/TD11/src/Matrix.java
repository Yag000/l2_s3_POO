import java.util.Arrays;

public class Matrix<T> {

    private T[][] tab;

    private class MatrixScanner<S> {

    }

    @SuppressWarnings("unchecked")
    public Matrix(T[][] tab) throws InvalidContentException {

        if (!checkContent(tab))
            throw new InvalidContentException();

        this.tab = (T[][]) new Object[tab.length][];

        for (int i = 0; i < tab.length; i++) {
            this.tab[i] = (T[]) new Object[tab[i].length];
            this.tab[i] = Arrays.copyOf(tab[i], tab[i].length);
        }
    }

    private boolean checkContent(T[][] tab) {
        return true;
    }

    public int nbRows() {
        return tab.length;
    }

    public int nbColumns() {
        return tab[0].length;
    }

    public <S> MatrixScanner<S> rowScanner(int i, AccFunction<S, T> accFunc, S initial) {
    }

    public <S> MatrixScanner<S> colScanner(int i, AccFunction<S, T> accFunc, S initial) {
    }

}
