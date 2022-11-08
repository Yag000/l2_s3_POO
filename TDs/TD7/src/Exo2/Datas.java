package Exo2;

import javax.swing.text.Position;

public class Datas {
    private final static int SIZE = 16;
    private Integer[] monTableau = new Integer[SIZE];

    public Datas() {
        for (int i = 0; i < SIZE; i++) {
            monTableau[i] = Integer.valueOf(i);
        }
    }

    // on definit une interface interne
    private interface DatasIterator
            extends java.util.Iterator<Integer> {
    }

    // la methode de base pour afficher en suivant un iterateur
    private void print(DatasIterator i) {
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }

    private class EvenIterator implements DatasIterator {
        int position = 0;

        @Override
        public boolean hasNext() {
            return position < SIZE;
        }

        @Override
        public Integer next() {
            position += 2;
            return monTableau[position - 2];
        }

    }

    public void printEven() {
        print(new EvenIterator());
    }

    public void printOdd() {

        class OddIterator implements DatasIterator {
            int position = 1;

            @Override
            public boolean hasNext() {
                return position < SIZE;
            }

            @Override
            public Integer next() {
                position += 2;
                return monTableau[position - 2];
            }

        }

        print(new OddIterator());
    }

    public void printBackwards() {
        print(new DatasIterator() {

            int position = SIZE - 1;

            @Override
            public boolean hasNext() {
                return position >= 0;
            }

            @Override
            public Integer next() {
                return monTableau[position--];
            }

        });
    }

    public static void main(String s[]) {
        Datas d = new Datas();
        d.printEven();
        d.printOdd();
        d.printBackwards();
    }
}
