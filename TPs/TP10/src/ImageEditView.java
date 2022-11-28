import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.awt.Graphics2D;

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
            ((Graphics2D) g).draw(selection.getRectangle());
        }

        private class Selection extends MouseAdapter implements MouseMotionListener {

            int x0, x1, y0, y1;

            public Rectangle getRectangle() {
                return new Rectangle(x0, y0, x1 - x0, y1 - y0);
            }

            @Override
            public void mousePressed(MouseEvent event) {
                x0 = event.getX();
                y0 = event.getY();

                cutButton.setEnabled(false);

                imagePane.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                x1 = event.getX();
                y1 = event.getY();

                cutButton.setEnabled(true);

                imagePane.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event) {
            }

        }
    }
}
