import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {

    JPanel panneauColore = new JPanel();

    JLabel etiqCouleur = new JLabel("Vert");

    Vue() {
        setTitle("Palette");
        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color initialColor = new Color(0, 255, 0);

        panneauColore.setBackground(initialColor);

        this.getContentPane().add(panneauColore);

        panneauColore.setLayout(new BorderLayout());

        etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);

        panneauColore.add(etiqCouleur, BorderLayout.CENTER);

    }
}
