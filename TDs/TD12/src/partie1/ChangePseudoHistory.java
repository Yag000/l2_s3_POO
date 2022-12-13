package partie1;

import java.util.ArrayList;
import java.util.List;

public class ChangePseudoHistory {
    List<Pair> history;

    public ChangePseudoHistory() {
        history = new ArrayList<>();
    }

    public void add(Pair pseudo) {
        history.add(pseudo);
    }

    public void printHistory() {

        for (Pair pseudo : history) {
            System.out.println(pseudo);
        }
    }

    public void followHistory(List<Pseudo> pseudos) {
        pseudos.forEach(pseudo -> {
            pseudo.setHistory(this);
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair pseudo : history) {
            sb.append(pseudo).append("\n");
        }
        return sb.toString();
    }

    public static class Pair {
        private String firstPseudo;
        private String secondPseudo;

        public Pair(String first, String second) {
            firstPseudo = first;
            secondPseudo = second;
        }

        public String getFirst() {
            return firstPseudo;
        }

        public String getSecond() {
            return secondPseudo;
        }

        @Override
        public String toString() {
            return firstPseudo + " -> " + secondPseudo;
        }
    }

}
