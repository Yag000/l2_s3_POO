import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.undo.CannotRedoException;

public class ImageEditView extends JFrame {

    JButton cutButton;
    JButton undoButton;
    JButton redoButton;

    ImagePane imagePane;
    ImageEditModel model;

    public ImageEditView(ImageEditModel model) {
        this.model = model;

        setTitle("Mon éditeur d'image");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        initButtons(menuBar);

        imagePane = new ImagePane();

        setContentPane(imagePane);

    }

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

            int x0;
            int x1;
            int y0;
            int y1;

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

                if (x0 != x1 || y0 != y1)
                    cutButton.setEnabled(true);

                imagePane.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event) {
            }

        }
    }

    private void initButtons(JMenuBar menuBar) {

        cutButton = new JButton("Cut");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        JButton quitButton = new JButton("Quit");

        cutButton.setEnabled(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);

        cutButton.addActionListener(e -> {
            model.saveCut(imagePane.selection.getRectangle());

            imagePane.repaint();

            cutButton.setEnabled(false);
            undoButton.setEnabled(true);
            redoButton.setEnabled(true);
        });

        undoButton.addActionListener(e -> {
            if (model.undoManager.canUndo()) {
                model.undoManager.undo();
            }
            imagePane.repaint();
        });

        redoButton.addActionListener(e -> {
            try {
                model.undoManager.redo();
            } catch (CannotRedoException ex) {
                // TODO: implement this without try/catch
                // On essaye de redo l'action et on catch l'exception qui se lève si l'action
                // est possible
            }

            imagePane.repaint();
        });

        quitButton.addActionListener(e -> System.exit(0));

        menuBar.add(cutButton);
        menuBar.add(undoButton);
        menuBar.add(redoButton);
        menuBar.add(quitButton);

    }
}
