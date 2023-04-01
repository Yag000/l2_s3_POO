import java.awt.EventQueue;

/**
 * Cette classe est le launcher de l'application.
 */
public class Launcher {
    public static void main(String[] args) {
        ImageEditModel model = new ImageEditModel("finrod_felagund.jpg");
        ImageEditView view = new ImageEditView(model);

        // Thread safe
        EventQueue.invokeLater(() -> {
            view.pack();
            view.setVisible(true);
        });
    }
}
