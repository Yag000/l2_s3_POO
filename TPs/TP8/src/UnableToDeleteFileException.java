/**
 * Cette classe est une exception personnalisée qui est levée lorsqu'un fichier
 * ne peut pas être supprimé. Pour sa création elle prend le chemin du fichier
 * pour pouvoir afficher un message d'erreur plus complet.
 */
public class UnableToDeleteFileException extends Exception {

    // Constructeur

    public UnableToDeleteFileException() {
    }

    /**
     * Constructeur pour un message détaillé sur le fichier.
     * 
     * @param path Chemin du fichier
     */
    public UnableToDeleteFileException(String path) {
        super("File " + path + " could not be opened");
    }

}