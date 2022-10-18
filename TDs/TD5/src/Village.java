import java.util.LinkedList;

public class Village {

    LinkedList<Roturier> villageois;

    public Village(LinkedList<Roturier> villageois) {
        this.villageois = villageois;
    }

    public LinkedList<Roturier> getVillageois() {
        return villageois;
    }

}
