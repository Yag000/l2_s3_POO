import java.util.Scanner;

/**
 * Cette classe represente un fichier texte. Elle contient le contenu du
 * fichier.
 */
public class FichierTexte extends Element implements Affichable, Editable {
    private String contenu;

    // Constructeurs

    public FichierTexte() {
        contenu = "";
    }

    public FichierTexte(String contenu) {
        this.contenu = contenu;
    }

    // Getter

    @Override
    public String getType() {
        return "texte";
    }

    // Méthodes

    @Override
    public void afficher() {
        System.out.println(contenu);
    }

    @Override
    public void editer(Scanner sc, boolean echo) {
        contenu = "";

        if (!sc.hasNext())
            return;

        StringBuilder bld = new StringBuilder();

        String nextValue = sc.nextLine();

        while (!nextValue.equals(".") && sc.hasNext()) {
            bld.append(nextValue);

            if (echo)
                System.out.println(nextValue);

            nextValue = sc.nextLine();

            if (!nextValue.equals("."))
                bld.append("\n");

        }

        contenu = bld.toString();
    }

    @Override
    public FichierTexte copy(Entree e) {
        FichierTexte clone = new FichierTexte();
        clone.contenu = this.contenu;
        return clone;
    }

}
