package partie1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // partie declarative
        Pseudo a = new Pseudo("a");
        Pseudo b = new Pseudo("b");
        Pseudo c = new Pseudo("c");
        Pseudo d = new Pseudo("d");
        ChangePseudoHistory h_ab = new ChangePseudoHistory();
        ChangePseudoHistory h_bc = new ChangePseudoHistory();
        // parametrages a faire pour que
        // h_ab conserve l'historique des modifications de a et b
        // h_bc conserve l'historique des modifications de b et c

        h_ab.followHistory(Arrays.asList(a, b));
        h_bc.followHistory(Arrays.asList(b, c));
        // ...
        // ...
        // modifications
        a.set("a1");
        b.set("b1");
        a.set("a2");
        c.set("c1");
        d.set("d1");
        // affichage des historiques observes
        System.out.println(h_ab);
        System.out.println(h_bc);
    }
}