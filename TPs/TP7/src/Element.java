abstract class Element implements Cloneable {
    public abstract String getType();

    public String toString() {
        return "fichier de type " + getType();

    }

    @Override
    protected abstract Element clone();

}