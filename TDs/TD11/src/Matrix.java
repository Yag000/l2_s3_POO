import java.util.Arrays;

public class Matrix<T> {

    private T[][] tab;

    protected class MatrixScanner<S> implements Accumulator<S> {

        private S acc;

        private int i;
        private int j;

        private int di;
        private int dj;

        private AccFunction<S, T> accFunction;

        public MatrixScanner(S acc, int i, int j, int di, int dj, AccFunction<S, T> accFunction) {
            this.acc = acc;
            this.i = i;
            this.j = j;
            this.di = di;
            this.dj = dj;
            this.accFunction = accFunction;
        }

        @Override
        public void accumulate(S s) {
            acc = accFunction.apply(acc, s, tab[i][j]);
            i += di;
            j += dj;

        }

        @Override
        public S read() {
            return acc;
        }

        @Override
        public boolean isOver() {
            return i < 0 || i >= tab.length || j < 0 || j >= tab[0].length;
        }

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

    protected boolean checkContent(T[][] tab) {
        return true;
    }

    public int nbRows() {
        return tab.length;
    }

    public int nbColumns() {
        return tab[0].length;
    }

    public <S> MatrixScanner<S> rowScanner(int i, AccFunction<S, T> accFunc, S initial) {
        return new MatrixScanner<>(initial, i, 0, 0, 1, accFunc);
    }

    public <S> MatrixScanner<S> colScanner(int i, AccFunction<S, T> accFunc, S initial) {
        return new MatrixScanner<>(initial, 0, i, 1, 0, accFunc);
    }

}
