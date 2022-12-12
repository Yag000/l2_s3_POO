package partie1;

import java.awt.Color;

public class Model {

    Color[] colors;

    /**
     * Constructeur avec une coleus aléatoire entre 10 choix.
     */
    public Model() {

        int random = (int) (Math.random() * 10 + 1);

        colors = new Color[random];

        for (int i = 0; i < random; i++) {
            colors[i] = intToColor(i + 1);
        }

    }

    private Color intToColor(int i) {
        switch (i) {
            case 1:
                return Color.CYAN;
            case 2:
                return Color.DARK_GRAY;
            case 3:
                return Color.GRAY;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.LIGHT_GRAY;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.ORANGE;
            case 8:
                return Color.PINK;
            case 9:
                return Color.RED;
            case 10:
                return Color.YELLOW;
            default:
                return Color.BLUE;
        }
    }

    public Color getColor(int i) {
        return colors[i];
    }

    public int getNbColors() {
        return colors.length;
    }

    public boolean gagne() {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[0]) {
                return false;
            }
        }

        return true;
    }
}
