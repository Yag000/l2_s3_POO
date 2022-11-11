public class EntreeSpeciale extends Entree {

    // Constructeurs

    public EntreeSpeciale() {
    }

    public EntreeSpeciale(Element element, String nom, Dossier parent) {
        super(element, nom, parent);
    }

    // Méthodes

    @Override
    public void remplacer(Element e) {
        System.out.println("Error");
    }

    @Override
    public void supprimer() {
        System.out.println("Error");
    }

}
