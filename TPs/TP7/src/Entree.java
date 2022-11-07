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
        element = e;

        if (e instanceof Dossier dossier) {
            parent = dossier.getParent().parent;
        }
    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}