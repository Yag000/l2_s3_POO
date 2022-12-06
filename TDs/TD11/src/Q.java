import java.util.Arrays;

import javax.swing.text.StyleConstants.FontConstants;

public class Q {

    static double dotProduct(Matrix<Double> m, int i, double[] b) {
        Double[] res = new Double[m.nbColumns()];

        AccFunction<Double, Double> accFunction = (acc, ext, donnee) -> {
            acc += donnee * b[ext.intValue()];
            return acc;
        };

        var sc = m.rowScanner(i, accFunction, 0.0);

        double counter = 0;
        while (!sc.isOver()) {
            sc.accumulate(counter);
            counter++;
        }

        return sc.read();

    }

    static boolean lowerBound(Matrix<Double> m, int j, double b) {
        AccFunction<Boolean, Double> accFunction = (acc, ext, donnee) -> {
            if (!acc)
                return false;
            return donnee >= b;
        };

        var sc = m.colScanner(j, accFunction, true);

        while (!sc.isOver()) {
            sc.accumulate(true);
        }

        return sc.read();
    }

    public static void main(String args[]) throws InvalidContentException {
        Double[][] t = { { 2.0, 3.0, 4.0 }, { 5.0, 6.0, 7.0 } };
        double[] b = { 1.0, 2.0, 2.0 };
        Matrix<Double> m = new Matrix<>(t);
        System.out.println(dotProduct(m, 1, b));
        System.out.println(lowerBound(m, 1, 4));

        Double[][] t1 = { { 1.0, 0.0, 4.0 }, { 0.0, 6.0, 0.0 } };
        FunctionalMatrix<Double> m1 = new FunctionalMatrix<>(t1);
        Number[] fun = new Double[3];
        fun = m1.content();
        System.out.println(Arrays.toString(fun));

    }

}
