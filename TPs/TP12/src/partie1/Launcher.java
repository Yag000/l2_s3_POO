package partie1;

public class Launcher {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {

                        Cadre c = new Cadre();
                        c.setVisible(true);

                    }
                });
    }

}
