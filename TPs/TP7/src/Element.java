public abstract class Element {
    public abstract String getType();

    /**
     * Renvoie une copie en profondeur de l'objet avec un nouveau parent en
     * paramètre
     * 
     * @param newParent
     * @return
     */
    public abstract Element copy(Entree newParent);

    @Override
    public String toString() {
        return "fichier de type " + getType();

    }

}