import java.util.List;
import java.util.LinkedList;

public class Dossier extends Element implements Affichable {

    Entree parent;
    List<Entree> entrees;

    public Dossier(Entree parent) {
        this.parent = parent;
        entrees = new LinkedList<Entree>();
        entrees.add(new EntreeSpeciale(this, ".", this));
        entrees.add(new EntreeSpeciale(parent.getParent(), "..", this));
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

    // Ça compile :)
    public Entree getEntree(String nom, boolean creer) {
        for (Entree e : entrees) {
            if (e.getNom().equals(nom))
                return e;
        }

        if (creer) {
            Entree newEntree = new Entree(null, nom, parent.getParent());
            entrees.add(newEntree);
            return newEntree;
        }

        return null;
    }

    @Override
    public String getType() {
        return "dossier";
    }

    @Override
    public void afficher() {
        for (Entree e : entrees) {
            System.out.println(e);
        }
    }

}
