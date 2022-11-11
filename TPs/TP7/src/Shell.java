import java.util.Scanner;

public class Shell {

    // Constantes pour les messages d'erreur

    private static final String IS_A_SPECIAL_FILE = " is a special file";
    private static final String NO_SUCH_FILE_OR_DIRECTORY = ": No such file or directory";
    private static final String NOT_A_DIRECTORY = ": Not a directory";
    private static final String FILE_NOT_FOUND = "File not found";

    // Attributs des dossiers

    private final Dossier root;
    private Dossier current;

    // Scanner pour gérer les entrées du Shell

    private Scanner scanner;

    // Constructeur

    public Shell() {
        root = new Dossier();
        current = root;
        scanner = new Scanner(System.in);
    }

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
     * Cherche un element dans l'arborescence, en gérant les / et les ..
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
     * Cherche un element dans l'arborescence, en gérant les / et les ..
     * 
     * @param pathList Nom de l'élément à chercher
     */
    private Entree find(String[] pathList) {
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
     * Cherche un element dans l'arborescence, en gérant les / et les ..
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
     * Cherche un fichier de texte dans l'arborescence, en gérant les / et les ..
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
     * Cherche un dossier dans l'arborescence, en gérant les / et les ..
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

    private void cat(String path) {
        FichierTexte texte = findFichierTexte(path);

        if (texte == null)
            System.out.println(FILE_NOT_FOUND);
        else
            texte.afficher();

    }

    private void cd(String path) {
        String[] pathList = path.split("/");

        for (String folder : pathList) {
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

    private void cd() {
        current = root;
    }

    private void ls(String path) {

        if (path == null || path.equals("")) {
            current.afficher();
            return;
        }

        Entree lastFolder = find(path);

        if (lastFolder == null)
            System.out.println("Folder not found");
        else if (lastFolder.getElement() instanceof Dossier dossier)
            dossier.afficher();
        else
            System.out.println(lastFolder.getNom() + " is not a folder");

    }

    private void mkdir(String path) {

        if (path == null || path.equals("")) {
            System.out.println("mkdir: missing operand");
            return;
        }

        if (isAllFolders(path)) {
            Dossier tmp = current;
            String[] pathList = path.split("/");

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

    private void mv(String oldPath, String newPath) {

        if (oldPath == null || oldPath.equals("")) {
            System.out.println("mv: missing operand");
            return;
        }

        Entree originalEntree = find(oldPath);

        if (originalEntree == null) {
            System.out.println("mv: " + oldPath + NO_SUCH_FILE_OR_DIRECTORY);
            return;
        }

        if (originalEntree instanceof EntreeSpeciale) {
            System.out.println("mv: " + oldPath + IS_A_SPECIAL_FILE);
            return;
        }

        String[] newPathList = newPath.split("/");
        Dossier newDossier;

        if (newPathList.length == 1) {
            Entree tmp = current.getEntree(newPath, false);
            newDossier = tmp == null || !(tmp.getElement() instanceof Dossier) ? current : (Dossier) tmp.getElement();
        }

        else
            newDossier = findLastDossier(newPath);

        if (newDossier == null) {
            System.out.println("mv: " + newPath + NO_SUCH_FILE_OR_DIRECTORY);
            return;
        }

        String newName = newDossier.getParent().getNom().equals(newPathList[newPathList.length - 1])
                ? originalEntree.getNom()
                : newPathList[newPathList.length - 1];

        // Only problem ""..""
        newDossier.ajouter(originalEntree.getElement(), newName);

        originalEntree.supprimer();

        if (newDossier.getEntree(newName, false).getElement() instanceof Dossier dossier) {
            dossier.updateParentDirectory();
        }
    }

    private void rm(String path) {
        Entree lastEntree = find(path);

        if (lastEntree instanceof EntreeSpeciale) {
            System.out.println("mv: " + path + IS_A_SPECIAL_FILE);
            return;
        }

        if (lastEntree == null)
            System.out.println(FILE_NOT_FOUND);
        else if (lastEntree.getElement() instanceof FichierTexte)
            lastEntree.supprimer();
        else
            System.out.println("rm: " + path + ": Is a directory");
    }

    private void ed(String path) {

        if (path == null || path.equals("")) {
            System.out.println("ed: missing operand");
            return;
        }

        String[] pathList = path.split("/");

        Entree e;

        if (pathList.length == 1) {
            current.ajouter(new FichierTexte(""), path);
            e = current.getEntree(path, true);
        } else {
            Dossier dossier = findLastDossier(path);

            if (dossier == null) {
                System.out.println("ed: " + path + NOT_A_DIRECTORY);
                return;
            }

            dossier.ajouter(new FichierTexte(""), pathList[pathList.length - 1]);
            e = dossier.getEntree(pathList[pathList.length - 1], false);
        }

        FichierTexte file = (FichierTexte) e.getElement();

        if (file == null) {
            System.out.println(FILE_NOT_FOUND);
            return;
        }

        System.out.println("Entrez le texte du fichier (terminez par une ligne contenant seulement un point)");
        file.editer(scanner, false);
    }

    private void cp(String oldPath, String newPath) {

        if (oldPath == null || oldPath.equals("") || newPath.equals("")) {
            System.out.println("mv: missing operand");
            return;
        }

        Entree oldEntree = find(oldPath);
        if (oldEntree == null) {
            System.out.println("cp: " + oldPath + NO_SUCH_FILE_OR_DIRECTORY);
            return;
        }

        if (oldEntree instanceof EntreeSpeciale) {
            System.out.println("mv: " + oldPath + IS_A_SPECIAL_FILE);
            return;
        }

        Entree newEntree;
        Dossier newDossier;
        String newName;

        if (newPath.split("/").length == 1) {
            newEntree = current.getParent();
            newDossier = current;
            newName = newPath;
        } else {
            newDossier = findLastDossier(newPath);

            if (newDossier == null) {
                System.out.println("cp: " + oldPath + NOT_A_DIRECTORY);
                return;
            } else {
                newName = newPath.split("/")[newPath.split("/").length - 1];
                newEntree = find(newPath, -1);
            }
        }

        newDossier.ajouter(oldEntree.getElement().copy(newEntree), newName);
    }

    private void pwd() {
        System.out.println(current.getChemin());
    }

    private void parser() {
        while (true) {
            System.out.print(current.getChemin() + "$ ");
            String[] commande = scanner.nextLine().split(" ");

            switch (commande[0]) {
                case "cat":
                    cat(commande[1]);
                    break;
                case "cd":
                    if (commande.length == 1)
                        cd();
                    else
                        cd(commande[1]);
                    break;
                case "ls":
                    ls(commande.length > 1 ? commande[1] : null);
                    break;
                case "mkdir":
                    mkdir(commande[1]);
                    break;
                case "mv":
                    mv(commande[1], commande[2]);
                    break;
                case "rm":
                    rm(commande[1]);
                    break;
                case "ed":
                    ed(commande[1]);
                    break;
                case "cp":
                    cp(commande[1], commande[2]);
                    break;
                case "pwd":
                    pwd();
                    break;
                case "quit":
                case "exit":
                    scanner.close();
                    return;
                case "":
                    break;
                default:
                    System.out.println("Command not found");
            }
        }
    }

    public static void main(String[] args) {
        new Shell();
    }
}