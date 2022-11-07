public class Entree {
    private Element element;
    private String nom;
    private Dossier parent;

    public Entree() {
    }

    public Entree(Element element, String nom, Dossier parent) {
        this.element = element;
        this.nom = nom;
        this.parent = parent;
    }

    public Element getElement() {
        return element;
    }

    public String getNom() {
        return nom;
    }

    public Dossier getParent() {
        return parent;
    }

    public void supprimer() {
        parent.supprimer(this);

        parent = null;
        nom = null;
        element = null;
    }

    public void remplacer(Element e) {

        if (element instanceof Dossier dossier)
            dossier.setParent(null);

        element = e;

        if (e instanceof Dossier dossier)
            dossier.setParent(this);

    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}