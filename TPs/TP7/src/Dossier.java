import java.util.List;

public class Dossier extends Element {

    Dossier parent;
    List<Entree> entrees;

    public Dossier(Dossier parent) {
        this.parent = parent;
    }

    @Override
    public String getType() {
        return "dossier";
    }

}
