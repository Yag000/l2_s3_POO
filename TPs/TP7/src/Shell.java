import java.util.Scanner;

public class Shell {

    // Constantes pour les messages d'erreur

    private static final String IS_A_SPECIAL_FILE = " is a special file";
    private static final String NO_SUCH_FILE_OR_DIRECTORY = ": No such file or directory";
    private static final String NOT_A_DIRECTORY = ": Not a directory";
    private static final String FILE_NOT_FOUND = "File not found";

    // Attributs des dossiers

    private final Dossier root;
    private Dossier courant;

    // Scanner pour gérer les entrées du Shell

    private Scanner scanner;

    // Constructeur

    public Shell() {
        root = new Dossier();
        courant = root;
        scanner = new Scanner(System.in);

        parser();
    }

    public Shell(Dossier first) {
        courant = first;

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

    // Helpers

    private void printMissingOperand(String command) {
        System.out.println(command + ": missing operand");
    }

    private void printTooManyOperands(String command) {
        System.out.println(command + ": too many operands");
    }

    // Méthodes de type Find

    /**
     * Cherche un element dans l'arborescence, en gérant les / et les ..
     * 
     * @param path Nom de l'élément à chercher
     */
    private Entree find(String path) {
        String[] pathList = path.split("/");
        Dossier tmp = this.courant;
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
        Dossier tmp = this.courant;
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

        Dossier tmp = this.courant;
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
        Dossier tmp = this.courant;
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
        Dossier tmp = this.courant;

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

    /**
     * Affiche le contenu du fichier passé en paramètre
     * 
     * @param path
     */
    private void cat(String path) {
        FichierTexte texte = findFichierTexte(path);

        if (texte == null)
            System.out.println(FILE_NOT_FOUND);
        else
            texte.afficher();

    }

    /**
     * Le shell change de dossier courant
     * 
     * @param path
     */
    private void cd(String path) {
        String[] pathList = path.split("/");

        for (String folder : pathList) {
            Entree e = courant.getEntree(folder, false);

            if (e == null) {
                System.out.println("Folder not found");
                return;
            }

            if (e.getElement() instanceof Dossier dossier) {
                courant = dossier;
            } else {
                System.out.println(e.getNom() + " is not a folder");
                return;
            }
        }
    }

    /**
     * Le dossier courant devient root
     */
    private void cd() {
        courant = root;
    }

    /**
     * Affiche les contenus du dossier passé en argument
     * 
     * @param path
     */
    private void ls(String path) {

        if (path == null || path.equals("")) {
            courant.afficher();
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

    /**
     * Affiche les contenus du dossier courant
     */
    private void ls() {
        courant.afficher();
    }

    /**
     * Crée un dossier à partir du dossier courrait. Il peut y avoir plusieurs
     * dossiers à créer dans la même arborescence. Par exemple : mkdir mkdir a/b/c/c
     * peut créer créer les dossiers a,b,c,d si a n'existe pas.
     * 
     * @param path
     */
    private void mkdir(String path) {

        if (path == null || path.equals("")) {
            printMissingOperand("mkdir");
            return;
        }

        if (isAllFolders(path)) {
            Dossier tmp = courant;
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

    /**
     * Déplace le premier element vers le deuxième. Si le deuxième est un dossier,
     * le fichier est déplacé dans ce dossier. Si le deuxième path fini par un nom
     * non défini l'element et déplacé et renommé.
     * 
     * @param oldPath
     * @param newPath
     */
    private void mv(String oldPath, String newPath) {

        if (oldPath == null || oldPath.equals("")) {
            printMissingOperand("mv");
            return;
        }

        // Gestion des cas où on ne peux pas déplacer le premier element

        Entree originalEntree = find(oldPath);

        if (originalEntree == null) {
            System.out.println("mv: " + oldPath + NO_SUCH_FILE_OR_DIRECTORY);
            return;
        }

        if (originalEntree instanceof EntreeSpeciale) {
            System.out.println("mv: " + oldPath + IS_A_SPECIAL_FILE);
            return;
        }

        // Obtention de la destination et du nouveau nom de l’élément.

        String[] newPathList = newPath.split("/");
        Dossier newDossier;

        if (newPathList.length == 1) {
            Entree tmp = courant.getEntree(newPath, false);
            newDossier = tmp == null || !(tmp.getElement() instanceof Dossier) ? courant : (Dossier) tmp.getElement();
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

        // Ajout de l'élément a sa nouvelle destination
        newDossier.ajouter(originalEntree.getElement(), newName);

        // On supprime l'élément de son ancienne destination
        originalEntree.supprimer();

        // Si l’élément est un dossier on actualise aussi son parent (en particulier
        // pour l'entrée "..")
        if (newDossier.getEntree(newName, false).getElement() instanceof Dossier dossier) {
            dossier.updateParentDirectory();
        }
    }

    /**
     * Élimine un fichier, ne marche pas sur les dossiers
     * 
     * @param path
     */
    private void rm(String path) {
        Entree lastEntree = find(path);

        // Gestion des cas spéciaux
        if (lastEntree instanceof EntreeSpeciale) {
            System.out.println("mv: " + path + IS_A_SPECIAL_FILE);
            return;
        }

        // On cherche a éliminer que les fichiers.
        if (lastEntree == null)
            System.out.println(FILE_NOT_FOUND);
        else if (lastEntree.getElement() instanceof FichierTexte)
            lastEntree.supprimer();
        else
            System.out.println("rm: " + path + ": Is a directory");
    }

    /**
     * Permet la modification du contenu d'un fichier passé en argument. Si le
     * fichier n'existait aps déjà il est crée.
     * 
     * @param path
     */
    private void ed(String path) {

        if (path == null || path.equals("")) {
            printMissingOperand("ed");
            return;
        }

        FichierTexte file = findFichierTexte(path);

        // Si le fichier n’existe pas il est crée
        if (file == null) {
            String[] pathList = path.split("/");

            if (pathList.length == 1) {
                courant.ajouter(new FichierTexte(""), path);
                file = (FichierTexte) courant.getEntree(path, true).getElement();

            } else {
                Dossier dossier = findLastDossier(path);

                if (dossier == null) {
                    System.out.println("ed: " + path + NOT_A_DIRECTORY);
                    return;
                }

                dossier.ajouter(new FichierTexte(""), pathList[pathList.length - 1]);
                file = (FichierTexte) dossier.getEntree(pathList[pathList.length - 1], false).getElement();
            }
        }

        System.out.println("Entrez le texte du fichier (terminez par une ligne contenant seulement un point)");
        file.editer(scanner, false);
    }

    private void cp(String oldPath, String newPath) {

        if (oldPath == null || oldPath.equals("") || newPath.equals("")) {
            printMissingOperand("cp");
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
            newEntree = courant.getParent();
            newDossier = courant;
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
        System.out.println(courant.getChemin());
    }

    private void parser() {
        while (true) {
            System.out.print(courant.getChemin() + "$ ");
            String[] commande = scanner.nextLine().split(" ");

            switch (commande[0]) {
                case "cat":
                    if (commande.length == 2)
                        cat(commande[1]);
                    else if (commande.length < 2)
                        printMissingOperand("cat");
                    else
                        printTooManyOperands("cat");
                    break;
                case "cd":
                    if (commande.length == 1)
                        cd();
                    else if (commande.length == 2)
                        cd(commande[1]);
                    else
                        printTooManyOperands("cd");
                    break;
                case "ls":
                    if (commande.length == 1)
                        ls();
                    else if (commande.length == 2)
                        ls(commande[1]);
                    else
                        printTooManyOperands("ls");
                    break;
                case "mkdir":
                    if (commande.length == 2)
                        mkdir(commande[1]);
                    else if (commande.length < 2)
                        printMissingOperand("mkdir");
                    else
                        printTooManyOperands("mkdir");
                    break;
                case "mv":
                    if (commande.length == 3)
                        mv(commande[1], commande[2]);
                    else if (commande.length < 3)
                        printMissingOperand("mv");
                    else
                        printTooManyOperands("mv");
                    break;
                case "rm":
                    if (commande.length == 2)
                        rm(commande[1]);
                    else if (commande.length < 2)
                        printMissingOperand("rm");
                    else
                        printTooManyOperands("rm");
                    break;
                case "ed":
                    if (commande.length == 2)
                        ed(commande[1]);
                    else if (commande.length < 2)
                        printMissingOperand("ed");
                    else
                        printTooManyOperands("ed");
                    break;
                case "cp":
                    if (commande.length == 3)
                        cp(commande[1], commande[2]);
                    else if (commande.length < 3)
                        printMissingOperand("cp");
                    else
                        printTooManyOperands("cp");
                    break;
                case "pwd":
                    if (commande.length == 1)
                        pwd();
                    else
                        printTooManyOperands("pwd");
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