package cours.classes_internes;

class PileChainee {

    public static class Noeud {
        private Noeud next;
        private int val;

        public Noeud(int val) {
            this.val = val;
        }

        public Noeud getSuivant() {
            return next;
        }

        public void setSuivant(Noeud n) {
            next = n;
        }

        public int getVal() {
            return val;
        }
    }

    private Noeud tete;

    public boolean estVide() {
        return tete == null;
    }

    public void empiler(Noeud n) {
        n.setSuivant(tete);
        tete = n;
    }

    public Noeud depiler() {
        Noeud tmp;
        if (!estVide()) {
            tmp = tete;
            tete = tete.getSuivant();
            return tmp;
        } else
            return null;
    }
}