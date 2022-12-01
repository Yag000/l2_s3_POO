import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * Model de l'application. Cette classe permet de gérer le coupage del'image et
 * les undo et redo.
 */
public class ImageEditModel {

    BufferedImage image;

    UndoManager undoManager = new UndoManager();

    // Constructeurs

    public ImageEditModel(String chemin) {
        try {
            this.image = ImageIO.read(new File(chemin));
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de l'image");
        }
    }

    // Classes internes

    /**
     * Cette classe represente un coupe d'image. Elle permet de undo et redo le
     * coupage.
     */
    private class Coupe {
        Rectangle z; // Zone de la coupe
        int[][] pixels; // Pixels de l'image

        Coupe(int x, int y, int width, int height, BufferedImage image) {
            this.z = new Rectangle(x, y, width, height);
            this.pixels = new int[width][height];

            // Boucle pour obtenir les pixels de l'image à couper
            for (int i = 0; i < width; i++)
                for (int j = 0; j < height; j++)
                    this.pixels[i][j] = image.getRGB(i, j);
        }

        /**
         * Cette méthode permet de couper l'image.
         */
        void doit() {
            ImageEditModel.this.clearZone(z);
        }

        /**
         * Cette méthode permet d'annuler une coupe.
         */
        void undo() {
            ImageEditModel.this.fillzone(z, pixels);
        }
    }

    /**
     * Classe auxiliare pour une coupe, elle étend {@code AbstractUndoableEdit} ce
     * qui permet d'utiliser un {@code UndoManager} pour gérer les undo et redo de
     * coupe.
     */
    private class CutEdit extends AbstractUndoableEdit {
        Coupe c;

        public CutEdit(Coupe c) {
            this.c = c;
        }

        @Override
        public void redo() throws CannotRedoException {
            c.doit();
        }

        @Override
        public void undo() throws CannotUndoException {
            c.undo();
        }
    }

    // Getter

    public BufferedImage getImage() {
        return image;
    }

    // Méthodes

    /**
     * Permet de remplier une zone {@code z} avec une nouvelle image encodé sous
     * forme d'un array de pixels
     * 
     * @param z      Zone a remplir
     * @param pixels Array qui contint l'image
     */
    public void fillzone(Rectangle z, int[][] pixels) {

        if (z.getWidth() != pixels.length)
            throw new IllegalArgumentException("La zone et le tableau ne sont pas de la même taille");

        for (int[] ligne : pixels)
            if (z.getHeight() != ligne.length)
                throw new IllegalArgumentException("La zone et le tableau ne sont pas de la même taille");

        for (int i = 0; i < z.getWidth(); i++)
            for (int j = 0; j < z.getHeight(); j++)
                image.setRGB((int) z.getX() + i, (int) z.getY() + j, pixels[i][j]);
    }

    /**
     * Rempli une zone {@code z} avec la couleur blanche.
     * 
     * @param z Zone à remplir
     */
    public void clearZone(Rectangle z) {
        Color color = Color.white;
        int srgb = color.getRGB();

        for (int i = 0; i < z.getWidth(); i++)
            for (int j = 0; j < z.getHeight(); j++)
                image.setRGB((int) z.getX() + i, (int) z.getY() + j, srgb);
    }

    /**
     * Cette méthode permet de sauvegarder une coupe, pour pouvoir couper et, après,
     * annuler ou refaire cette action.
     * 
     * @param z Zone a couper
     */
    public void saveCut(Rectangle z) {
        BufferedImage subImage = image.getSubimage((int) z.getX(), (int) z.getY(), (int) z.getWidth(),
                (int) z.getHeight());

        Coupe c = new Coupe((int) z.getX(), (int) z.getY(), (int) z.getWidth(), (int) z.getHeight(), subImage);

        c.doit();

        CutEdit ce = new CutEdit(c);

        undoManager.addEdit(ce);
    }

}
