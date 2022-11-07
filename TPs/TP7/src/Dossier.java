import java.util.List;
import java.util.LinkedList;

public class Dossier extends Element {

    Entree parent;
    List<Entree> entrees;

    public Dossier(Entree parent) {
        this.parent = parent;
        entrees = new LinkedList<Entree>();
    }

    public Entree getParent() {
        return parent;
    }

    public void supprimer(Entree entree) {
        entrees.remove(entree);
    }

    @Override
    public String getType() {
        return "dossier";
    }

}
