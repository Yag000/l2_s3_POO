package partie1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class Cadre extends JFrame {

    JPanel mainPanel;
    Model model = new Model();
    Carre[] carres;

    public Cadre() {
        this.setSize(600, 600);
        this.setTitle("TP 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);
        setContentPane(mainPanel);

        carres = new Carre[model.getNbColors()];

        for (int i = 0; i < model.getNbColors(); i++) {
            carres[i] = new Carre();
            mainPanel.add(carres[i]);
        }
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
            setBounds((int) (Math.random() * 550), (int) (Math.random() * 550), 50, 50);
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            xClick = e.getX();
            yClick = e.getY();
            isMoving = !isMoving;
            System.out.println(isMoving);
            model.setColor(id, Color.GREEN);
            setBackground(Color.GREEN);

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
            if (!isMoving) {
                model.setColor(id, Color.BLUE);
                setBackground(Color.BLUE);
            }

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