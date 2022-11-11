import java.util.Scanner;
//TODO: Work with entree spéciale

public class Shell {

    private static final String NOT_A_DIRECTORY = ": Not a directory";
    private static final String FILE_NOT_FOUND = "File not found";

    private final Dossier root;
    private Dossier current;

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

    // Méthodes de type Find

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param path Nom de l'élément à chercher
     */
    private Entree find(String path) {
        String[] pathList = path.split("/");
        Dossier tmp = this.current;
        Entree res = null;

        for (String s : pathList) {
            res = tmp.getEntree(s, false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                tmp = (Dossier) res.getElement();

        }

        return res;
    }

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ...
     * 
     * @param path Nom de l'élément à chercher
     */
    private Entree find(String[] path) {
        Dossier tmp = this.current;
        Entree res = null;

        for (String s : path) {
            res = tmp.getEntree(s, false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                tmp = (Dossier) res.getElement();

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

        Dossier tmp = this.current;
        Entree res = null;

        for (int i = 0; i < depth; i++) {
            res = tmp.getEntree(pathList[i], false);
            if (res == null)
                return null;
            if (res.getElement() instanceof Dossier)
                tmp = (Dossier) res.getElement();
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

    /**
     * Cherche un dossier dans l'arborescence, en gérant les / et les ...
     * 
     * @param path
     * @return
     */

    private Dossier findLastDossier(String path) {

        String[] pathList = path.split("/");
        Dossier tmp = this.current;
        Dossier res = null;
        int counter = 0;

        for (String s : pathList) {
            Entree e = tmp.getEntree(s, false);
            if (e == null) {
                if (counter == pathList.length - 1)
                    return res;
                return null;
            }

            if (e.getElement() instanceof Dossier) {
                res = (Dossier) e.getElement();
                tmp = res;
            } else {
                return counter == pathList.length - 1 ? res : null;
            }

            counter++;

        }

        return res;
    }

    /**
     * @param path
     * @return true si tout les éléments sont des dossiers ou ils n'existent pas
     */
    private boolean isAllFolders(String path) {

        String[] pathList = path.split("/");
        Dossier tmp = this.current;

        for (String s : pathList) {
            Entree e = tmp.getEntree(s, false);

            if (e == null)
                return true;

            if (e.getElement() instanceof Dossier)
                tmp = (Dossier) e.getElement();
            else
                return false;
        }

        return false;
    }

    // Commandes

    // Works
    private void cat(String name) {
        FichierTexte texte = findFichierTexte(name);

        if (texte == null)
            System.out.println(FILE_NOT_FOUND);
        else
            texte.afficher();

    }

    // Works
    private void cd(String folderName) {
        String[] s = folderName.split("/");

        for (String folder : s) {
            Entree e = current.getEntree(folder, false);

            if (e == null) {
                System.out.println("Folder not found");
                return;
            }

            if (e.getElement() instanceof Dossier dossier) {
                current = dossier;
            } else {
                System.out.println(e.getNom() + " is not a folder");
                return;
            }
        }
    }

    // Works
    private void cd() {
        current = root;
    }

    // Works
    private void ls(String name) {

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

    // Works
    private void mkdir(String name) {

        if (name == null || name.equals("")) {
            System.out.println("mkdir: missing operand");
            return;
        }

        if (isAllFolders(name)) {
            Dossier tmp = current;
            String[] pathList = name.split("/");

            for (String s : pathList) {
                Entree e = tmp.getEntree(s, false);

                if (e == null) {
                    tmp.ajouter(new Dossier(new Entree(null, s, tmp)), s);
                    e = tmp.getEntree(s, false);
                }

                tmp = (Dossier) e.getElement();
            }
        }
    }

    // TODO: update to use findLastDossier
    // TODO: completely broken

    private void mv(String name, String newFolder) {

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
                System.out.println("mv: " + name + NOT_A_DIRECTORY);
                return;
            }

            if (lastEntreeOfNew.getElement() instanceof Dossier newDossier)
                newDossier.ajouter(entreeOfOriginal.getElement(), pathToNew[pathToNew.length - 1]);
            else
                dossier.ajouter(entreeOfOriginal.getElement(), lastEntreeOfNew.getNom());

            entreeOfOriginal.supprimer();
        } else
            System.out.println("mv: " + name + NOT_A_DIRECTORY);
    }

    // Works
    private void rm(String name) {
        Entree e = find(name);

        if (e == null)
            System.out.println(FILE_NOT_FOUND);
        else if (e.getElement() instanceof FichierTexte)
            e.supprimer();
        else
            System.out.println("rm: " + name + ": Is a directory");
    }

    // Works
    private void ed(String filename) {

        if (filename == null || filename.equals("")) {
            System.out.println("ed: missing operand");
            return;
        }

        String[] path = filename.split("/");

        Entree e;

        System.out.println(path.length);

        if (path.length == 1) {
            current.ajouter(new FichierTexte(""), filename);
            e = current.getEntree(filename, true);
        } else {
            Dossier dossier = findLastDossier(filename);

            if (dossier == null) {
                System.out.println("ed: " + filename + NOT_A_DIRECTORY);
                return;
            }

            dossier.ajouter(new FichierTexte(""), path[path.length - 1]);
            e = dossier.getEntree(path[path.length - 1], false);
        }

        FichierTexte f = (FichierTexte) e.getElement();

        if (f == null) {
            System.out.println(FILE_NOT_FOUND);
            return;
        }

        System.out.println("Entrez le texte du fichier (terminez par une ligne contenant seulement un point)");
        f.editer(scanner, false);
    }

    // Works
    private void cp(String oldFolder, String newFolder) {

        if (oldFolder == null || oldFolder.equals("") || newFolder.equals("")) {
            System.out.println("mv: missing operand");
            return;
        }

        Entree oldDossier = find(oldFolder);
        if (oldDossier == null) {
            System.out.println("cp: " + oldFolder + ": No such file or directory");
            return;
        }

        Entree newEntree;
        Dossier newDossier;
        String newName;

        if (newFolder.split("/").length == 1) {
            newEntree = current.getParent();
            newDossier = current;
            newName = newFolder;
        } else {
            newDossier = findLastDossier(newFolder);

            if (newDossier == null) {
                System.out.println("cp: " + oldFolder + NOT_A_DIRECTORY);
                return;
            } else {
                newName = newFolder.split("/")[newFolder.split("/").length - 1];
                newEntree = find(newFolder, -1);
            }
        }

        newDossier.ajouter(oldDossier.getElement().copy(newEntree), newName);
    }

    // Works
    private void pwd() {
        System.out.println(current.getChemin());
    }

    // Works
    private void parser() {
        while (true) {
            System.out.print(current.getChemin() + "$ ");
            String[] s = scanner.nextLine().split(" ");

            switch (s[0]) {
                case "cat":
                    cat(s[1]);
                    break;
                case "cd":
                    if (s.length == 1)
                        cd();
                    else
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
                case "pwd":
                    pwd();
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