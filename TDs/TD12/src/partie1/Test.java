package partie1;

public class Test {
    public static void main(String[] args) {
        // partie declarative
        Pseudo<String> a = new Pseudo<>("a");
        Pseudo<String> b = new Pseudo<>("b");
        Pseudo<String> c = new Pseudo<>("c");
        Pseudo<String> d = new Pseudo<>("d");
        ChangePseudoHistory<String> h_ab = new ChangePseudoHistory();
        ChangePseudoHistory<String> h_bc = new ChangePseudoHistory();
        // parametrages a faire pour que
        // h_ab conserve l'historique des modifications de a et b
        // h_bc conserve l'historique des modifications de b et c

        a.addObserver(h_ab);
        b.addObserver(h_ab);
        b.addObserver(h_bc);
        c.addObserver(h_bc);
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