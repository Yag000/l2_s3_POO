import java.util.Scanner;

public class Shell {

    public Dossier root;
    public Dossier current;

    private Scanner scanner;

    public Shell(Dossier first) {
        current = first;

        if (first.getParent().getElement() == first) {
            root = first;
        } else {

            Dossier tmp = first;

            while (tmp.getParent().getParent() != null)
                tmp = tmp.getParent().getParent();

            root = tmp;
        }

        scanner = new Scanner(System.in);

        parser();

    }

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param path Nom de l'élément à chercher
     */
    private Entree find(String path) {
        String[] pathList = path.split("/");
        Dossier current = this.current;
        Entree res = null;

        for (String s : pathList) {
            res = current.getEntree(s, false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                current = (Dossier) res.getElement();

        }

        return res;
    }

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param path Nom de l'élément à chercher
     */
    private Entree find(String[] path) {
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

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param path  Chemin du dossier à chercher
     * @param depth Profondeur de la recherche
     * @return
     */
    private Entree find(String path, int depth) {

        String[] pathList = path.split("/");

        if (depth == 0)
            return find(pathList);
        else if (depth >= pathList.length)
            return find(pathList);
        else if (depth < 0)
            depth = pathList.length - (-depth % pathList.length);

        Dossier current = this.current;
        Entree res = null;

        for (int i = 0; i < depth; i++) {
            res = current.getEntree(pathList[i], false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                current = (Dossier) res.getElement();
        }

        return res;
    }

    /**
     * Cherche un fichier de texte dans l'arborescence, en gérant les / et les ...
     * 
     * @param path
     * @return
     */
    private FichierTexte findFichierTexte(String path) {
        Entree e = find(path);
        if (e == null)
            return null;
        if (e.getElement() instanceof FichierTexte)
            return (FichierTexte) e.getElement();
        return null;
    }

    public void cat(String name) {
        FichierTexte texte = findFichierTexte(name);

        if (texte == null)
            System.out.println("File not found");
        else
            texte.afficher();

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

    // TODO: Can create test/tes1/test2

    public void mkdir(String name) {

        if (name == null || name.equals("")) {
            System.out.println("mkdir: missing operand");
            return;
        }

        String[] path = name.split("/");
        Entree e = find(name, -1);

        if (e == null) {
            if (path.length == 1)
                current.ajouter(new Dossier(current.getParent()), path[0]);
            else
                System.out.println("mkdir: cannot create directory '" + name + "': No such file or directory");
            return;
        }

        if (e.getElement() instanceof Dossier dossier) {
            dossier.ajouter(new Dossier(e), path[path.length - 1]);
        } else {
            System.out.println("mkdir: " + name + ": Not a directory");
        }
    }

    public void mv(String name, String newFolder) {

        if (name == null || name.equals("")) {
            System.out.println("mv: missing operand");
            return;
        }

        Entree entreeOfOriginal = find(name);

        String[] pathToNew = newFolder.split("/");
        Entree entreeOfNew = find(newFolder, -1);

        if (entreeOfNew.getElement() instanceof Dossier dossier) {
            Entree lastEntreeOfNew = dossier.getEntree(pathToNew[pathToNew.length - 1], false);
            if (lastEntreeOfNew == null) {
                System.out.println("mv: " + name + ": Not a directory");
                return;
            }

            if (lastEntreeOfNew.getElement() instanceof Dossier newDossier)
                newDossier.ajouter(entreeOfOriginal.getElement(), pathToNew[pathToNew.length - 1]);
            else
                dossier.ajouter(entreeOfOriginal.getElement(), lastEntreeOfNew.getNom());

            entreeOfOriginal.supprimer();
        } else
            System.out.println("mv: " + name + ": Not a directory");
    }

    public void rm(String name) {
        Entree e = find(name);

        if (e == null)
            System.out.println("File not found");
        else if (e.getElement() instanceof FichierTexte texte)
            e.supprimer();
        else
            System.out.println("rm: " + name + ": Is a directory");
    }

    public void ed(String filename) {

        if (filename == null || filename.equals("")) {
            System.out.println("ed: missing operand");
            return;
        }

        String[] path = filename.split("/");

        Entree e;

        if (path.length == 1) {
            current.ajouter(new FichierTexte(""), filename);
            e = current.getEntree(filename, true);
        } else {
            Entree folderEntry = find(filename, -1);
            if (folderEntry.getElement() instanceof Dossier dossier) {
                dossier.ajouter(new FichierTexte(""), path[path.length - 1]);
                e = dossier.getEntree(path[path.length - 1], false);
            } else {
                System.out.println("ed: " + filename + ": Not a directory");
                return;
            }
        }

        FichierTexte f = (FichierTexte) e.getElement();

        if (f == null) {
            System.out.println("File not found");
            return;
        }

        System.out.println("Entrez le texte du fichier (terminez par une ligne contenant seulement un point)");
        f.editer(scanner, false);
        System.out.println("fin");
    }

    public void cp(String name, String newFolder) {

        if (name == null || name.equals("")) {
            System.out.println("mv: missing operand");
            return;
        }

        Entree entreeOfOriginal = find(name);
        Entree entreeOfNew = find(newFolder);

        if (entreeOfNew.getElement() instanceof Dossier dossier) {
            dossier.ajouter(entreeOfOriginal.getElement().clone(), entreeOfOriginal.getNom());
        } else
            System.out.println("mv: " + name + ": Not a directory");
    }

    private void parser() {
        while (true) {
            System.out.print(current.getParent().getNom() + "$ ");
            String[] s = scanner.nextLine().split(" ");

            switch (s[0]) {
                case "cat":
                    cat(s[1]);
                    break;
                case "cd":
                    cd(s[1]);
                    break;
                case "ls":
                    ls(s.length > 1 ? s[1] : null);
                    break;
                case "mkdir":
                    mkdir(s[1]);
                    break;
                case "mv":
                    mv(s[1], s[2]);
                    break;
                case "rm":
                    rm(s[1]);
                    break;
                case "ed":
                    ed(s[1]);
                    break;
                case "cp":
                    cp(s[1], s[2]);
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Command not found");
            }
        }
    }

    public static void main(String[] args) {

        new Shell(new Dossier());
    }

}
