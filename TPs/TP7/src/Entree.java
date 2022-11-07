public class Entree {
    private Element element;
    private String nom;
    private Dossier parent;

    public Entree(Dossier p, String n, Element e) {
    }

    public Element getElement() {
        return element;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}