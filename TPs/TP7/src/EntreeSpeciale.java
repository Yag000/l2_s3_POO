public class EntreeSpeciale extends Entree {

    public EntreeSpeciale() {
    }

    public EntreeSpeciale(Element element, String nom, Dossier parent) {
        super(element, nom, parent);
    }

    @Override
    public void remplacer(Element e) {
        System.out.println("Error");
    }

    @Override
    public void supprimer() {
        System.out.println("Error");
    }

}
