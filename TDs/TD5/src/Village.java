import java.util.LinkedList;

public class Village {

    LinkedList<Roturier> villageois;

    public Village(LinkedList<Roturier> villageois) {
        this.villageois = villageois;
    }

    public LinkedList<Roturier> getVillageois() {
        return villageois;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        var newvillageois = new LinkedList<Roturier>();
        for (Roturier r : villageois)
            newvillageois.add((Roturier) r.clone());

        return new Village(newvillageois);
    }

}
