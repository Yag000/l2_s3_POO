abstract class Element implements Cloneable {
    public abstract String getType();

    public String toString() {
        return "fichier de type " + getType();

    }

    public abstract Element copy(Entree newParent);

    @Override
    protected abstract Element clone();

}