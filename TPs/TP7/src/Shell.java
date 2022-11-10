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

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param name Nom de l'élément à chercher
     */
    private Entree find(String name) {
        String[] path = name.split("/");
        Dossier current = this.current;
        Entree res = null;

        for (String s : path) {
            res = current.getEntree(s, false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                current = (Dossier) res.getElement();

        }

        return res;

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

    public void cd(String folderName) {
        String[] s = folderName.split("/");

        for (String folder : s) {
            Entree e = current.getEntree(folder, false);

            if (e == null) {
                System.out.println("Folder not found");
                return;
            }

            if (e.getElement() instanceof Dossier dossier)
                current = dossier;
            else {
                System.out.println(e.getNom() + " is not a folder");
                return;
            }
        }
    }

    public void ls(String name) {

        if (name == null || name.equals("")) {
            current.afficher();
            return;
        }

        Entree e = find(name);

        if (e == null)
            System.out.println("Folder not found");
        else if (e.getElement() instanceof Dossier dossier)
            dossier.afficher();
        else
            System.out.println(e.getNom() + " is not a folder");

    }

    public void mkdir(String name) {
        current.ajouter(new Dossier(current.getParent()), name);
    }

    public void mv(String name, String newFolder) {
        Entree e = current.getEntree(name, false);

        if (e == null) {
            System.out.println("File not found");
            return;
        }

        String[] s = newFolder.split("/");

        Dossier tmp = current;

        for (String folder : s) {
            Entree entree = tmp.getEntree(folder, false);

            if (entree == null) {
                System.out.println("Folder not found");
                return;
            }

            if (entree.getElement() instanceof Dossier dossier)
                tmp = dossier;
            else {
                System.out.println(entree.getNom() + " is not a folder");
                return;
            }
        }

        tmp.ajouter(e.getElement(), e.getNom());
        current.supprimer(e);
    }

    public static void main(String[] args) {

    }

}
