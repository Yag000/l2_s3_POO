package Exo3;

public class Comparer {
    public static void main(String[] args) {
        int[] a = { 10, 30, 5, 0, -2, 100, -9 };
        afficher(a);
        // croissant
        trier(a, new Comparateur() {

            @Override
            public boolean plusGrand(int x, int y) {
                return x > y;
            }

        });

        afficher(a);

        // decroissant
        trier(a, new Comparateur() {

            @Override
            public boolean plusGrand(int x, int y) {
                return x < y;
            }

        });
        afficher(a);

        // croissant de la valeur absolue
        trier(a, new Comparateur() {

            @Override
            public boolean plusGrand(int x, int y) {
                return Math.abs(x) > Math.abs(y);
            }

        });
        afficher(a);
    }

    static void afficher(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("\n-------");
    }

    static void trier(int[] x, Comparateur c) {
        boolean change = false;
        do {
            change = false;
            for (int i = 0; i < x.length - 1; i++) {
                if (c.plusGrand(x[i], x[i + 1])) {
                    int tmp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = tmp;
                    change = true;
                }
            }
        } while (change);
    }
}
