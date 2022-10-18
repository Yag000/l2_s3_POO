import java.util.LinkedList;

public class Village implements Cloneable {

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

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        int len = ((Village) obj).villageois.size();
        if (len != this.villageois.size())
            return false;
        for (int i = 0; i < len; i++)
            if (!((Village) obj).villageois.get(i).equals(this.villageois.get(i)))
                return false;

        return true;

    }

}
