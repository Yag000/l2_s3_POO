import java.util.List;

public class Dossier extends Element {

    Dossier parent;
    List<Entree> entrees;

    public Dossier(Dossier parent) {
        this.parent = parent;
    }

    public void supprimer(Entree entree) {
        entrees.remove(entree);
    }

    @Override
    public String getType() {
        return "dossier";
    }

}
