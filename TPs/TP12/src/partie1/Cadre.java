package partie1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * Constructeur de la classe Cadre. Initialise la taille, le titre et la
 * fermeture de la fenêtre, ainsi que les carrés à afficher.
 */
public class Cadre extends JFrame {
    JPanel etiquette;
    JPanel mainPanel;

    JPanel information;
    JLabel informationLabel;

    Model model = new Model();
    Carre[] carres;

    /**
     * Constructeur de la classe Cadre. Initialise la taille, le titre et la
     * fermeture de la fenêtre, ainsi que les carrés à afficher.
     */
    public Cadre() {
        this.setSize(600, 660);
        this.setTitle("TP 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 600, 600);
        setContentPane(mainPanel);

        information = new JPanel();
        informationLabel = new JLabel(model.toString());
        information.add(informationLabel);
        information.setBounds(0, 600, 600, 60);
        information.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(information);

        carres = new Carre[model.getNbColors()];

        for (int i = 0; i < model.getNbColors(); i++) {
            carres[i] = new Carre();
            mainPanel.add(carres[i]);
        }
    }

    private void updateInfomation() {
        informationLabel.setText(model.toString());
        information.repaint();
    }

    /**
     * Méthode qui vérifie si l'utilisateur a gagné la partie.
     * 
     * @return true si l'utilisateur a gagné, false sinon.
     */
    public boolean gagne() {
        return model.gagne();
    }

    /**
     * Méthode qui affiche un message de félicitation lorsque l'utilisateur a gagné
     * la partie. Ajoute également un écouteur d'événement de souris pour quitter
     * l'application lorsque l'utilisateur clique sur le message.
     */
    public void finJeu() {
        if (!gagne())
            return;

        etiquette = new JPanel();
        etiquette.setBounds(0, 0, 600, 660);
        etiquette.setBackground(Color.WHITE);

        JLabel label = new JLabel("Bravo, vous avez gagné! Cliquez pour fermer la fenêtre.");
        etiquette.setLayout(new GridBagLayout());
        etiquette.add(label);

        setContentPane(etiquette);

        etiquette.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                //
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //
            }

        });

    }

    /**
     * Classe interne représentant un carré affiché dans la fenêtre de
     * l'application.
     * Cette classe implémente l'interface MouseInputListener pour gérer les
     * événements de souris.
     */
    private class Carre extends JPanel implements MouseInputListener {

        private static boolean isMouseOnASquare = false;

        static int nb = 0;

        int id;

        boolean isMoving = false;
        int xClick;
        int yClick;

        /**
         * Constructeur de la classe Carre. Initialise l'identifiant du carré, sa
         * couleur, sa position aléatoire et
         * les écouteurs d'événements de souris.
         */
        public Carre() {
            id = nb++;

            setBackground(model.getColor(id));
            setBounds((int) (Math.random() * 550), (int) (Math.random() * 550), 50, 50);
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        /**
         * Méthode appelée lorsque l'utilisateur clique sur un carré.
         * Change la couleur du carré en vert et vérifie si l'utilisateur a gagné la
         * partie.
         */

        @Override
        public void mouseClicked(MouseEvent e) {
            if (isMouseOnASquare != isMoving)
                return;

            xClick = e.getX();
            yClick = e.getY();

            isMoving = !isMoving;
            isMouseOnASquare = isMoving;

            model.setColor(id, Color.GREEN);
            setBackground(Color.GREEN);
            finJeu();
            updateInfomation();

        }

        @Override
        public void mousePressed(MouseEvent e) {
            //
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //
        }

        /**
         * Méthode appelée lorsque la souris entre dans un carré.
         * Change la couleur du carré en bleu et vérifie si l'utilisateur a gagné la
         * partie.
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if (!isMouseOnASquare) {
                model.setColor(id, Color.BLUE);
                setBackground(Color.BLUE);
                finJeu();
                updateInfomation();
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            //
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //
        }

        /**
         * Méthode appelée lorsque la souris se déplace sur un carré.
         * Elle actualise la position du carré s'il est en mouvement..
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            if (isMoving) {
                int x = getX() + e.getX() - xClick;
                int y = getY() + e.getY() - yClick;

                setLocation(x, y);
            }
        }

    }

    /**
     * Classe représentant le modèle du jeu, gérant les carrés et vérifiant si
     * l'utilisateur a gagné.
     */

    private class Model {

        Color[] colors;

        /**
         * Constructeur de la classe Model. Initialise le nombre de couleurs
         * utilisées dans l'application et crée le tableau de couleurs.
         */
        public Model() {

            int random = (int) (Math.random() * 10 + 1);

            colors = new Color[random];

            for (int i = 0; i < random; i++) {
                colors[i] = intToColor(i + 1);
            }

        }

        /**
         * Méthode qui convertit un entier en couleur.
         * 
         * @param i l'entier à convertir en couleur.
         * @return la couleur correspondant à l'entier.
         */
        private Color intToColor(int i) {
            switch (i) {
                case 1:
                    return Color.CYAN;
                case 2:
                    return Color.DARK_GRAY;
                case 3:
                    return Color.RED;
                case 4:
                    return Color.YELLOW;
                case 5:
                    return Color.ORANGE;
                case 6:
                    return Color.MAGENTA;
                case 7:
                    return Color.LIGHT_GRAY;
                case 8:
                    return Color.PINK;
                case 9:
                    return Color.GRAY;
                case 10:
                    return Color.GREEN;
                default:
                    return Color.BLUE;
            }
        }

        /**
         * Méthode qui retourne la couleur d'un carré du tableau {@code colors}.
         * 
         * @param i l'indice du carré à récupérer dans le tableau {@code colors}.
         * @return la couleur du carré.
         */
        public Color getColor(int i) {
            return colors[i];
        }

        /**
         * Méthode qui retourne le nombre de couleurs différentes utilisées dans le jeu.
         * 
         * @return le nombre de couleurs différentes utilisées dans le jeu.
         */
        public int getNbColors() {
            return colors.length;
        }

        /**
         * Méthode qui permet de changer la couleur d'un carré du tableau
         * {@code colors}.
         * 
         * @param i     l'indice du carré à modifier dans le tableau {@code colors}.
         * @param color la nouvelle couleur du carré.
         */
        public void setColor(int i, Color c) {
            colors[i] = c;
        }

        /**
         * Méthode qui vérifie si l'utilisateur a gagné la partie.
         * 
         * @return true si l'utilisateur a gagné, false sinon.
         */
        public boolean gagne() {
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] != colors[0]) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public String toString() {
            int green = 0;
            int blue = 0;
            int other = 0;

            for (Color c : colors) {
                if (c == Color.BLUE) {
                    blue++;
                }

                else if (c == Color.GREEN) {
                    green++;
                } else {
                    other++;
                }

            }

            return "Il y a " + blue + " carrés bleus, " + green + " verts et " + other + " d'autres couleurs.";
        }

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                () -> {
                    Cadre c = new Cadre();
                    c.setVisible(true);
                });
    }

}