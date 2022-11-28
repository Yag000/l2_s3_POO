import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditView extends JFrame {

    JButton cutButton;
    JButton undoButton;
    JButton redoButton;

    ImagePane imagePane;
    ImageEditModel model;

    private class ImagePane extends JPanel {

    }
}
