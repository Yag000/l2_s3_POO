import java.util.LinkedList;
import java.util.List;

public class Dossier extends Element implements Affichable {

    Entree parent;
    List<Entree> entrees;

    /**
     * Constructeur de root
     */
    public Dossier() {
        entrees = new LinkedList<Entree>();
        parent = new Entree(this, "/", this);

        entrees.add(new EntreeSpeciale(this, ".", this));
        entrees.add(new EntreeSpeciale(parent.getParent(), "..", this));
    }

    public Dossier(Entree parent) {
        this.parent = parent;
        entrees = new LinkedList<Entree>();

        entrees.add(new EntreeSpeciale(this, ".", this));
        entrees.add(new EntreeSpeciale(parent.getParent(), "..", this));
    }

    public Entree getParent() {
        return parent;
    }

    // TODO: Does not wok...
    public void setParent(Entree e) {
        parent = e;
    }

    public void supprimer(Entree entree) {
        entrees.remove(entree);
    }

    public void ajouter(Element e, String nom) {
        Entree newEntree = new Entree(null, nom, this);
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

    public String getChemin() {
        return parent.getChemin();
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

    public Dossier copy(Entree newParent) {
        Dossier newDossier = new Dossier(newParent);

        for (Entree e : entrees)
            if (!(e instanceof EntreeSpeciale)) {
                newDossier.ajouter(null, e.getNom());
                Entree newE = newDossier.getEntree(e.getNom(), false);
                newE.setElement(e.getElement().copy(newE));
            }

        return newDossier;
    }
}