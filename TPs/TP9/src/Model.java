import java.awt.Color;

//TODO: RGB odes not work use 255 values
public class Model {
    private int rouge;
    private int vert;
    private int bleu;

    private Color lastColor;

    public Model() {
    }

    public Model(int rouge, int vert, int bleu) {
        this.rouge = (int) (rouge * 255. / 100.);
        this.vert = (int) (vert * 255. / 100.);
        this.bleu = (int) (bleu * 255. / 100.);
    }

    public Color getColor() {
        return new Color(rouge, vert, bleu);
    }

    public void setLastColor(Color c) {
        lastColor = c;
    }

    public Color getLastColor() {
        return lastColor;
    }

    public void setColor(Color c) {
        rouge = c.getRed();
        vert = c.getGreen();
        bleu = c.getBlue();
    }

    public Color getComplementary() {
        return new Color(255 - rouge, 255 - vert, 255 - bleu);
    }

}
