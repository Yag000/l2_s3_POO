import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
    private String contenu;

    public FichierTexte() {
        contenu = "";
    }

    public FichierTexte(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String getType() {
        return "texte";
    }

    @Override
    public void afficher() {
        System.out.println(contenu);
    }

    @Override
    public void editer(Scanner sc, boolean echo) {
        contenu = "";

        if (!sc.hasNext())
            return;

        String nextValue = sc.nextLine();

        while (!nextValue.equals(".") && sc.hasNext()) {
            contenu += nextValue;

            if (echo)
                System.out.println(nextValue);

            nextValue = sc.nextLine();

            if (!nextValue.equals("."))
                contenu += "\n";

        }
    }

    @Override
    public FichierTexte copy(Entree e) {
        FichierTexte clone = new FichierTexte();
        clone.contenu = this.contenu;
        return clone;
    }

}
