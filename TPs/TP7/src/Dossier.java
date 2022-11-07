import java.util.List;
import java.util.LinkedList;

public class Dossier extends Element implements Affichable {

    Entree parent;
    List<Entree> entrees;

    public Dossier(Entree parent) {
        this.parent = parent;
        entrees = new LinkedList<Entree>();
    }

    public Entree getParent() {
        return parent;
    }

    public void setParent(Entree e) {
        this.parent = e;
    }

    public void supprimer(Entree entree) {
        entrees.remove(entree);
    }

    public void ajouter(Element e, String nom) {
        Entree newEntree = new Entree(null, nom, parent.getParent());
        newEntree.remplacer(e);
        entrees.add(newEntree);

    }

    @Override
    public String getType() {
        return "dossier";
    }

    @Override
    public void afficher() {
        System.out.println(". " + getType());
        if (parent != null)
            System.out.println(".. " + getType());

        for (Entree e : entrees) {
            System.out.println(e);
        }
    }

}
