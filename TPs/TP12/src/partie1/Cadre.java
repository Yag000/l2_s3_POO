package partie1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Cadre extends JFrame {

    JPanel mainPanel;

    public Cadre() {
        this.setSize(600, 600);
        this.setTitle("TP 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        setContentPane(mainPanel);

        Carre c = new Carre();
        mainPanel.add(c);
    }

    private class Carre extends JPanel {

        public Carre() {

            setBackground(Color.BLUE);
            setBounds(100, 200, 50, 50);

        }

    }

}