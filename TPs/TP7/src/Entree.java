public class Entree {
    private Element element;
    private String nom;
    private Dossier parent;

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

    public void supprimer() {
        parent.remove(this);
    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}