import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;

public class ImageEditView extends JFrame {

    JButton cutButton;
    JButton undoButton;
    JButton redoButton;

    ImagePane imagePane;
    ImageEditModel model;

    private class ImagePane extends JPanel {

        Selection selection = new Selection();

        public ImagePane() {
            setPreferredSize(new Dimension(model.getImage().getWidth(), model.getImage().getHeight()));

            addMouseListener(selection);
            addMouseMotionListener(selection);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
        }

    }
}
