import java.awt.Color;

/**
 * Cette classe est le Model du modèle MVC.
 */
public class Model {
    private int rouge; // Valeur du rouge
    private int vert; // Valeur du vert
    private int bleu; // Valeur du bleu

    private Color lastColor; // Couleur sauvegardée

    // Constructeurs

    public Model() {
    }

    public Model(int rouge, int vert, int bleu) {
        lastColor = new Color(rouge, vert, bleu);
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
    }

    public Model(Color c) {
        lastColor = c;
        this.rouge = c.getRed();
        this.vert = c.getGreen();
        this.bleu = c.getBlue();
    }

    // Getters

    public Color getColor() {
        return new Color(rouge, vert, bleu);
    }

    public Color getLastColor() {
        return lastColor;
    }

    /**
     * Renvoie la couleur complementaire de la couleur actuelle.
     * 
     * @return Couleur complementaire de la couleur actuelle
     */
    public Color getComplementary() {
        return new Color(255 - rouge, 255 - vert, 255 - bleu);
    }

    // Setters
    public void setLastColor(Color c) {
        lastColor = c;
    }

    public void setColor(Color c) {
        rouge = c.getRed();
        vert = c.getGreen();
        bleu = c.getBlue();
    }

}
