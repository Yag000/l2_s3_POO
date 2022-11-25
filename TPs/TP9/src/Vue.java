import javax.swing.*;
import java.awt.*;

/**
 * Cette classe est la Vue du modèle MVC.
 */
public class Vue extends JFrame {

    Model model; // Model du MVC
    Controller controller; // Controller du MVC

    JPanel panneauColore = new JPanel(); // Panneau qui affiche la couleur

    JPanel panneauChoix = new JPanel(); // Panneau qui controle la couleur

    JLabel etiqCouleur = new JLabel(); // Label qui affiche la couleur

    JSlider rougeSlider; // Slider pour le rouge
    JSlider vertSlider; // Slider pour le vert
    JSlider bleuSlider; // Slider pour le bleu

    Vue(Color initialColor) {
        setTitle("Palette");
        setSize(800, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialisation de tous les éléments du Frame
        this.getContentPane().setLayout(new GridLayout());

        initPanneauChoix();

        this.getContentPane().add(panneauChoix);

        initPanneauColore(initialColor);

        this.getContentPane().add(panneauColore);
    }

    // Getters

    /**
     * Retourne la liste avec les valeurs des Sliders convertis en RGB (Le slider
     * represente un pourcentage de chaque couleur, il suffit de convertir ça à
     * l'échelle 0-255)
     * 
     * @return Liste avec les valeurs des Sliders convertis en RGB
     */
    public int[] getSlidersValues() {
        return new int[] { (int) (rougeSlider.getValue() * (255. / 100.)),
                (int) (vertSlider.getValue() * (255. / 100.)), (int) (bleuSlider.getValue() * (255. / 100.)) };
    }

    // Setters

    public void setModel(Model model) {
        this.model = model;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // Méthodes

    // Méthodes privées de type init

    /**
     * Initialise le panneau de la couleur.
     * 
     * @param initialColor La couleur initiale.
     */
    private void initPanneauColore(Color initialColor) {

        panneauColore.setLayout(new BorderLayout());

        etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);

        panneauColore.add(etiqCouleur, BorderLayout.CENTER);

        panneauColore.setBackground(initialColor);
    }

    /**
     * Initialisation d'un slider avec les valeurs par défaut.
     * 
     * @param name Le nom du slider.
     * @return Le slider initialisé.
     */
    private JSlider initSlider(String name) {

        JSlider slider = new JSlider(0, 100);

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

    /**
     * Initialise les boutons de la vue
     */
    private void initButtons() {
        var panneauChoixButton = new JPanel(); // Panneau pour les boutons
        panneauChoixButton.setLayout(new GridLayout(1, 3, 0, 200));

        // Bouton pour stocker la couleur
        JButton memoButton = new JButton("Mémoriser");
        panneauChoixButton.add(memoButton);
        memoButton.addActionListener(event -> controller.updateLastColor());

        // Bouton pour récupérer la couleur mémorisée
        JButton rappelButton = new JButton("S'en rappeler");
        panneauChoixButton.add(rappelButton);
        rappelButton.addActionListener(event -> controller.updateColor(model.getLastColor()));

        // Bouton pour la couleur complémentaire
        JButton complementaireButton = new JButton("Complémentaire");
        panneauChoixButton.add(complementaireButton);
        complementaireButton.addActionListener(event -> controller.updateColor(model.getComplementary()));

        panneauChoix.add(panneauChoixButton);
    }

    /**
     * Initialise le tableau de choix
     */
    private void initPanneauChoix() {

        panneauChoix.setLayout(new GridLayout(4, 1, 0, 100));

        this.rougeSlider = initSlider("rouge");
        this.vertSlider = initSlider("vert");
        this.bleuSlider = initSlider("bleu");

        initButtons();
    }

    // Méthodes publiques de type update

    /**
     * Met à jour la couleur du panneau de couleur.
     */
    public void miseAJour() {

        Color color = model.getColor();
        panneauColore.setBackground(color);

        // Update de l'etiquette de couleur

        // On obtient la valeur hexadécimale de la couleur
        etiqCouleur.setText("#" + Integer.toHexString(color.getRGB()).substring(2));

        // On met comme couleur des lettres la couleur inverse de la couleur du panneau
        etiqCouleur.setForeground(model.getComplementary());

    }

    /**
     * Met à jour les sliders.
     * 
     * @param c la couleur à partir de laquelle on met à jour les sliders.
     */
    public void updateSliders(Color c) {
        rougeSlider.setValue((int) (c.getRed() * (100. / 255.)));
        vertSlider.setValue((int) (c.getGreen() * (100. / 255.)));
        bleuSlider.setValue((int) (c.getBlue() * (100. / 255.)));
    }

}
