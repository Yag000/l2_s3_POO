import javax.swing.*;

import java.awt.*;

//TODO: complemetaire ne marche pas
//TODO: problemes avec les buttons (exceptions)

public class Vue extends JFrame {

    Model model;
    Controller controller;

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

    public JSlider[] getSliders() {
        return new JSlider[] { rougeSlider, vertSlider, bleuSlider };
    }

    public void miseAJour() {
        Color color = model.getColor();
        panneauColore.setBackground(color);

        etiqCouleur.setText("#" + Integer.toHexString(color.getRGB()).substring(2));
        etiqCouleur.setForeground(model.getComplementary());

    }

    private JSlider initSlider(JSlider slider, String name) {

        slider = new JSlider(0, 100);

        slider.setName(name);

        slider.setPaintLabels(true);

        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);

        slider.addChangeListener((event) -> {
            controller.sliderMoved();
        });

        panneauChoix.add(slider);

        return slider;

    }

    private void initButtons() {
        var panneauChoixButton = new JPanel();

        panneauChoixButton.setLayout(new GridLayout(1, 3, 0, 200));

        memoButton = new JButton("Mémoriser");
        panneauChoixButton.add(memoButton);
        memoButton.addActionListener((event) -> {
            model.setLastColor(model.getColor());
        });

        rappelButton = new JButton("S'en rappeler");
        panneauChoixButton.add(rappelButton);
        rappelButton.addActionListener((event) -> {
            controller.updateColor(model.getLastColor());
        });

        complementaireButton = new JButton("Complémentaire");
        panneauChoixButton.add(complementaireButton);
        complementaireButton.addActionListener((event) -> {
            controller.updateColor(model.getComplementary());
        });

        panneauChoix.add(panneauChoixButton);
    }

    private void initPanneauChoix() {

        panneauChoix.setLayout(new GridLayout(4, 1, 0, 100));

        this.rougeSlider = initSlider(rougeSlider, "rouge");
        this.vertSlider = initSlider(vertSlider, "vert");
        this.bleuSlider = initSlider(bleuSlider, "bleu");

        initButtons();
    }

    public void updateSliders(Color c) {
        rougeSlider.setValue((int) (c.getRed() * (100. / 255.)));
        vertSlider.setValue((int) (c.getGreen() * (100. / 255.)));
        bleuSlider.setValue((int) (c.getBlue() * (100. / 255.)));
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
