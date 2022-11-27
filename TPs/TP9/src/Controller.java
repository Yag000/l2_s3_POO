import java.awt.Color;

/**
 * Cette classe est le Controller du modèle MVC.
 */
public class Controller {
    Model model; // Model du MVC
    Vue vue; // Vue du MVC

    // Constructors
    public Controller(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    // Methods

    /**
     * Cette méthode est appelée par la Vue quand un slider est modifié. Elle
     * change la couleur du modèle et met à jour la couleur du panneau.
     */
    public void sliderMoved() {
        int[] slidersValues = vue.getSlidersValues();

        model.setColor(new Color(slidersValues[0], slidersValues[1], slidersValues[2]));

        vue.miseAJour();
    }

    /**
     * Cette méthode est appelée par la Vue quand un bouton est cliqué. Elle
     * change la couleur du modèle, met à jour la couleur du panneau et met à jour
     * les sliders.
     * 
     * @param c Nouvelle couleur
     */
    public void updateColor(Color c) {
        model.setColor(c);
        vue.miseAJour();
        vue.updateSliders(c);
    }

    /**
     * La couleur est mise à jour avec la couleur stocké.
     */
    public void setColorToLast() {
        updateColor(model.getLastColor());
    }

    /**
     * La couleur devient la couleur complementaire.
     */
    public void setColorToComplementary() {
        updateColor(model.getComplementary());
    }

    /**
     * La couleur stocké du modèle est mise à jour avec la valeur actuelle.
     */
    public void updateLastColor() {
        model.setLastColor(model.getColor());
    }

}
