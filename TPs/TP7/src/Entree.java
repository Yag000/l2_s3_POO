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

    public void setParent(Dossier parent) {
        this.parent = parent;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void supprimer() {
        parent.supprimer(this);

        parent = null;
    }

    public void remplacer(Element e) {

        if (element instanceof Dossier dossier)
            dossier.setParent(null);

        element = e;

        if (element instanceof Dossier dossier)
            dossier.setParent(this);
    }

    public String getChemin() {
        if (parent.getParent() == this)
            return "/";

        String s = parent.getChemin();

        if (s.equals("/"))
            return s + nom;
        else
            return s + "/" + nom;
    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}