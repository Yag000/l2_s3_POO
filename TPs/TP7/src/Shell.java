import javax.lang.model.util.ElementScanner14;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Shell {

    public Dossier root;
    public Dossier current;

    public Shell(Dossier first) {
        current = first;

        Dossier tmp = first;

        while (tmp.getParent().getParent() != null)
            tmp = tmp.getParent().getParent();

        root = tmp;
    }

    public void cat(String name) {
        Entree e = current.getEntree(name, false);
        if (e == null)
            System.out.println("File not found");
        else if (e.getElement() instanceof FichierTexte texte)
            texte.afficher();
        else
            System.out.println("cat: " + name + ": Is a directory");

    }

}
