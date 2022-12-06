public class FunctionalMatrix<T extends Number> extends Matrix<T> {

    public FunctionalMatrix(T[][] tab) throws InvalidContentException {
        super(tab);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean checkContent(T[][] tab) {
        for (int i = 0; i < tab[0].length; i++) {
            int count = 0;
            for (int j = 0; j < tab.length; j++) {
                if (tab[j][i].intValue() != 0) {
                    if (count == 0)
                        count++;
                    else
                        return false;

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
