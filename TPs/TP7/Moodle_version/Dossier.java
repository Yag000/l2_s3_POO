import java.util.LinkedList;
import java.util.List;

/**
 * Représentation d'un dossier
 */
public class Dossier extends Element implements Affichable {

    Entree parent;
    List<Entree> entrees;

    // Constructeurs

    /**
     * Constructeur de root ("/")
     */
    public Dossier() {
        entrees = new LinkedList<>();
        parent = new Entree(this, "/", this);

        entrees.add(new EntreeSpeciale(this, ".", this));
        entrees.add(new EntreeSpeciale(parent.getParent(), "..", this));
    }

    /**
     * Constructeur de dossier
     * 
     * @param parent
     */
    public Dossier(Entree parent) {
        this.parent = parent;
        entrees = new LinkedList<>();

        entrees.add(new EntreeSpeciale(this, ".", this));
        entrees.add(new EntreeSpeciale(parent.getParent(), "..", this));
    }

    // Getters

    public Entree getParent() {
        return parent;
    }

    /**
     * Renvoi l'entrée correspondant au nom donné dans un dossier
     * 
     * @param nom   Nom de l'entrée
     * @param creer si true, crée l'entrée si elle n'existe pas
     * @return l'entrée correspondant au nom donné, null si elle n'existe pas
     */
    public Entree getEntree(String nom, boolean creer) {
        // On a besoin que ce soit public pour pouvoir l'utiliser dans la classe Shell
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

    /**
     * @return le chemin absolu du dossier
     */
    public String getChemin() {
        return parent.getChemin();
    }

    @Override
    public String getType() {
        return "dossier";
    }

    // Setter

    public void setParent(Entree e) {
        parent = e;
    }

    // Methods

    /**
     * Actualise l'entrée ".." du dossier. Utile lorsqu'on déplace un dossier.
     */
    public void updateParentDirectory() {
        Entree parentDirectory = getEntree("..", false);
        parentDirectory.setParent(this);
        parentDirectory.setElement(parent.getParent());
    }

    /**
     * Elimine une entrée du dossier
     * 
     * @param entree entrée à supprimer
     */
    public void supprimer(Entree entree) {
        entrees.remove(entree);
    }

    /**
     * Ajoute un élément au dossier
     * 
     * @param e   élément à ajouter
     * @param nom nom de l'élément
     */
    public void ajouter(Element e, String nom) {
        Entree newEntree = new Entree(null, nom, this);
        newEntree.remplacer(e);
        entrees.add(newEntree);
    }

    @Override
    public void afficher() {
        for (Entree e : entrees) {
            System.out.println(e);
        }
    }

    /**
     * Renvoie une copie en profondeur du dossier en modifiant le dossier parent
     * 
     * @param newParent le nouveau parent du dossier
     * @return Une copie en profondeur de ce dossier avec le nouveau parent
     * 
     */
    @Override
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