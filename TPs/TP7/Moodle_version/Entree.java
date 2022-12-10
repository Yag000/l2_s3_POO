/**
 * Cette classe represente l'entrée d'un élément de l'arborescence. Elle
 * contient l'élément, son nom et son parent.
 */
public class Entree {
    private Element element;
    private String nom;
    private Dossier parent;

    // Constructeurs

    public Entree() {
    }

    public Entree(Element element, String nom, Dossier parent) {
        this.element = element;
        this.nom = nom;
        this.parent = parent;
    }

    // Getters

    public Element getElement() {
        return element;
    }

    public String getNom() {
        return nom;
    }

    public Dossier getParent() {
        return parent;
    }

    /**
     * @return le chemin absolu du dossier
     */
    public String getChemin() {
        if (parent.getParent() == this)
            return "/";

        String s = parent.getChemin();

        if (s.equals("/"))
            return s + nom;
        else
            return s + "/" + nom;
    }

    // Setters

    public void setParent(Dossier parent) {
        this.parent = parent;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    // Méthodes

    /**
     * Supprime l'entrée de l'arborescence
     */
    public void supprimer() {
        parent.supprimer(this);

        parent = null;
    }

    /**
     * Remplace l'élément par un autre
     * 
     * @param e
     */
    public void remplacer(Element e) {

        if (element instanceof Dossier dossier)
            dossier.setParent(null);

        element = e;

        if (element instanceof Dossier dossier)
            dossier.setParent(this);
    }

    @Override
    public String toString() {
        return nom + " (" + element.getType() + ")";
    }

}