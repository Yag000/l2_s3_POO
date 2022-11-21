public class Palette {
    private Vue view;
    private Model model;
    private Controller controller;

    public Palette() {
        model = new Model(255, 0, 0);
        view = new Vue();

        controller = new Controller(model, view);

        view.setController(controller);
        view.setModel(model);

        view.setVisible(true);

        view.miseAJour();
    }

    public static void main(String[] args) {
        new Palette();
    }
}