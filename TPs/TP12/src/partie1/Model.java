package partie1;

import java.awt.Color;

public class Model {

    Color color;

    /**
     * Constructeur avec une coleus aléatoire entre 10 choix.
     */
    public Model() {

        int random = (int) (Math.random() * 10);

        switch (random) {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.CYAN;
                break;
            case 2:
                color = Color.DARK_GRAY;
                break;
            case 3:
                color = Color.GRAY;
                break;
            case 4:
                color = Color.GREEN;
                break;
            case 5:
                color = Color.LIGHT_GRAY;
                break;
            case 6:
                color = Color.MAGENTA;
                break;
            case 7:
                color = Color.ORANGE;
                break;
            case 8:
                color = Color.PINK;
                break;
            case 9:
                color = Color.RED;
                break;
            case 10:
                color = Color.YELLOW;
                break;
            default:
                color = Color.BLACK;
                break;
        }

    }
}
