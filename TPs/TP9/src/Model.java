import java.awt.Color;

public class Model {
    private int rouge;
    private int vert;
    private int bleu;

    public Model() {
    }

    public Model(int rouge, int vert, int bleu) {
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
    }

    public Color getColor() {
        return new Color(rouge, vert, bleu);
    }

    public void setRouge(int rouge) {
        this.rouge = rouge;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }

    public void setBleu(int bleu) {
        this.bleu = bleu;
    }

}
