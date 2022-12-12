package partie1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class Cadre extends JFrame {

    JPanel mainPanel;
    Model model = new Model();;

    public Cadre() {
        this.setSize(600, 600);
        this.setTitle("TP 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);
        setContentPane(mainPanel);

        Carre c = new Carre();
        mainPanel.add(c);
    }

    public boolean gagne() {
        return model.gagne();
    }

    private class Carre extends JPanel implements MouseInputListener {

        static int nb = 0;

        int id;

        boolean isMoving = false;
        int xClick;
        int yClick;

        public Carre() {
            id = nb++;

            setBackground(model.getColor(id));
            setBounds(100, 200, 50, 50);
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            xClick = e.getX();
            yClick = e.getY();
            isMoving = !isMoving;
            System.out.println(isMoving);

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseMoved(MouseEvent e) {

            if (isMoving) {
                int x = getX() + e.getX() - xClick;
                int y = getY() + e.getY() - yClick;

                setLocation(x, y);
            }
        }

    }

}