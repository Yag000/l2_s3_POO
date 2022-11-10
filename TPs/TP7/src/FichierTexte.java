import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
    private String contenu;

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

        if (nextValue.equals("."))
            return;

        do {
            contenu += nextValue + "\n";

            if (echo)
                System.out.println(nextValue);

            nextValue = sc.nextLine();

        } while (sc.hasNext() && !nextValue.equals("."));
    }

    @Override
    protected FichierTexte clone() {
        return new FichierTexte(contenu);
    }

}
