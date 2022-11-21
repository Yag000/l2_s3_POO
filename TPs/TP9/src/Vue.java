import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {

    JPanel panneauColore = new JPanel();

    Vue() {
        setTitle("Palette");
        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color initialColor = new Color(0, 255, 0);

        panneauColoer.setBackground(initialColor);

        this.getContentPane().add(panneauColore);
    }
}
