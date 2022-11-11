import java.util.Scanner;

public interface Editable {

    /**
     * Permet d'éditer le contenu d'un fichier
     * 
     * @param sc   Scanner pour lire les entrées de l'utilisateur
     * @param echo Si true, affiche les entrées de l'utilisateur
     */
    public void editer(Scanner sc, boolean echo);
}
