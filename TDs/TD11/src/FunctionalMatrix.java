public class FunctionalMatrix<T extends Number> extends Matrix<T> {

    public FunctionalMatrix(T[][] tab) throws InvalidContentException {
        super(tab);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean checkContent(T[][] tab) {
        for (T[] row : tab) {
            boolean flag = false;

            for (T elem : row) {
                if (elem.intValue() != 0) {
                    if (flag)
                        return false;
                    flag = true;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    T[] content() {
        T[] res = (T[]) new Number[nbColumns()];

        AccFunction<Integer, T> accFunction = (acc, ext, donnee) -> {
            if (donnee.intValue() != 0)
                return donnee.intValue();
            return acc;
        };

        for (int i = 0; i < nbColumns(); i++) {

            MatrixScanner<Integer> sc = colScanner(i, accFunction, 0);

            while (!sc.isOver()) {
                sc.accumulate(0);
            }

            res[i] = (T) sc.read();
        }

        return res;

    }

}
