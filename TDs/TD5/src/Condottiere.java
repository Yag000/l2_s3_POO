import java.util.LinkedList;

public class Condottiere extends Personne {
    LinkedList<Archer> archers;
    LinkedList<Fantassin> fantassins;

    public Condottiere(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    public Condottiere(String nom, int argent, int pdv, LinkedList<Archer> archers, LinkedList<Fantassin> fantassins) {
        super(nom, argent, pdv);
        this.archers = archers;
        this.fantassins = fantassins;
    }

    private void giveToAllies(int argent) {
        int len = archers.size() + fantassins.size();

        for (Archer a : archers) {
            a.gain(argent / len);
        }

        for (Fantassin f : fantassins) {
            f.gain(argent / len);
        }

    }

    public void attaque(Village v) {
        var villageois = v.getVillageois();

        for (Roturier r : villageois) {
            int gain = r.getArgent() / 2;
            r.perte(gain);
            gain(gain / 2);
            giveToAllies(gain / 2);

        }
    }

    // TODO: eveywhere test for null and exeptions

}
