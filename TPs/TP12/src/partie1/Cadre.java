package partie1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cadre extends JFrame {

    JPanel mainPanel;

    public Cadre() {
        this.setSize(600, 600);
        this.setTitle("TP 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();

    }

    private class Carre extends JPanel {

    }

}