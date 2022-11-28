
import java.awt.EventQueue;

public class Launcher {
    public static void main(String[] args) {
        ImageEditModel model = new ImageEditModel("finrod_felagund.jpg");
        ImageEditView view = new ImageEditView(model);

        EventQueue.invokeLater(() -> {

            view.pack();
            view.setVisible(true);
        });

    }
}
