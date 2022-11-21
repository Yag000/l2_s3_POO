import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.plaf.PanelUI;

import java.awt.*;

public class Vue extends JFrame {

    JPanel panneauColore = new JPanel();

    JPanel panneauChoix = new JPanel();

    JLabel etiqCouleur = new JLabel("Vert");

    JButton memoButton;
    JButton rappelButton;
    JButton complementaireButton;

    JSlider rougeSlider;
    JSlider vertSlider;
    JSlider bleuSlider;

    Vue() {
        setTitle("Palette");
        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color initialColor = new Color(0, 255, 0);

        panneauColore.setBackground(initialColor);

        this.getContentPane().setLayout(new GridLayout());

        this.getContentPane().add(panneauChoix);

        panneauColore.setLayout(new BorderLayout());

        etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);

        panneauColore.add(etiqCouleur, BorderLayout.CENTER);

        initPanneauChoix();

        this.getContentPane().add(panneauColore);

    }

    private void initSlider(JSlider slider, String name) {

        slider = new JSlider(0, 100);

        slider.setName(name);

        slider.setPaintLabels(true);

        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panneauChoix.add(slider);

    }

    private void initButtons() {
        var panneauChoixButton = new JPanel();

        panneauChoixButton.setLayout(new GridLayout(1, 3));

        memoButton = new JButton("Mémoriser");
        panneauChoixButton.add(memoButton);

        rappelButton = new JButton("S'en rappeler");
        panneauChoixButton.add(rappelButton);

        complementaireButton = new JButton("Complémentaire");
        panneauChoixButton.add(complementaireButton);

        panneauChoix.add(panneauChoixButton);
    }

    private void initPanneauChoix() {

        panneauChoix.setLayout(new GridLayout(4, 1));

        initSlider(rougeSlider, "rouge");
        initSlider(vertSlider, "vert");
        initSlider(bleuSlider, "bleu");

        initButtons();
    }
}
