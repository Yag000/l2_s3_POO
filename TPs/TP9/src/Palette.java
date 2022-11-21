import java.awt.Color;

public class Palette {
    private Vue view;
    private Model model;
    private Controller controller;

    private final static Color INITIAL_COLOR = Color.GREEN;

    public Palette() {
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