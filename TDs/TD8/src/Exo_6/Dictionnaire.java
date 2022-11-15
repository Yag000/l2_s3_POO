package Exo_6;

import java.util.LinkedList;

import Exo_5.ListeDEntier;

public class Dictionnaire {

    LinkedList<Pair> list;

    private class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class ValeurNonTrouveeException extends Exception {

    }

    public void set(String key, int value) {
        for (Pair p : list) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }

        list.add(new Pair(key, value));
    }

    public int get(String key) throws ValeurNonTrouveeException {
        for (Pair p : list)
            if (p.key.equals(key))
                return p.value;

        throw new ValeurNonTrouveeException();
    }
}
