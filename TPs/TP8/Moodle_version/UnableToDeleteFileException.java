public class UnableToDeleteFileException extends Exception {

    public UnableToDeleteFileException(String path) {
        super("File " + path + " could not be opened");
    }

}