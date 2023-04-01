import java.awt.Color;

/**
 * Cette classe sert à initialiser la palette de couleurs.
 */
public class Palette {
    private Vue view; // Vue du MVC
    private Model model; // Model du MVC
    private Controller controller; // Controller du MVC

    private static final Color INITIAL_COLOR = Color.GREEN; // Couleur initiale

    public Palette() {
        // Initialisation du MVC

        model = new Model(INITIAL_COLOR);
        view = new Vue(INITIAL_COLOR);

        controller = new Controller(model, view);

        view.setController(controller);
        view.setModel(model);

        view.setVisible(true);

        controller.updateColor(INITIAL_COLOR);
    }

    public static void main(String[] args) {
        new Palette();
    }
}