package cours.classes_internes;

public class Test {

    public static void main(String[] args) {
        PileChainee p = new PileChainee();
        PileChainee.Noeud n;
        for (int i = 0; i < 12; i++) {
            n = new PileChainee.Noeud(i);
            p.empiler(n);
        }
        while (!p.estVide()) {
            System.out.println((p.depiler()).getVal());
        }
    }
}
