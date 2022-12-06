import java.util.Arrays;

public class Matrix<T> {

    private T[][] tab;

    private class MatrixScanner<S> implements Accumulator<S> {

        private S acc;

        private int x;
        private int y;

        private int stepX;
        private int stepY;

        private AccFunction<S, T> accFunction;

        public MatrixScanner(S acc, int x, int y, int stepX, int stepY, AccFunction<S, T> accFunction) {
            this.acc = acc;
            this.x = x;
            this.y = y;
            this.stepX = stepX;
            this.stepY = stepY;
            this.accFunction = accFunction;
        }

        @Override
        public void accumulate(S s) {
            accFunction.apply(acc, s, tab[x][y]);
            x += stepX;
            y += stepY;

        }

        @Override
        public S read() {
            return acc;
        }

        @Override
        public boolean isOver() {
            return x < 0 || x >= tab.length || y < 0 || y >= tab[0].length;
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
        return new MatrixScanner<S>(initial, i, 0, 1, 0, accFunc);
    }

    public <S> MatrixScanner<S> colScanner(int i, AccFunction<S, T> accFunc, S initial) {
        return new MatrixScanner<S>(initial, 0, i, 0, 1, accFunc);
    }

}
