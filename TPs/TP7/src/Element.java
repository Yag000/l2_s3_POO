public abstract class Element {
    public abstract String getType();

    public String toString() {
        return "fichier de type " + getType();

    }

    public abstract Element copy(Entree newParent);

}