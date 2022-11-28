import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class ImageEditModel {

    BufferedImage image;

    UndoManager undoManager = new UndoManager();

    public ImageEditModel(String chemin) {
        try {
            this.image = ImageIO.read(new File(chemin));
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de l'image");
        }
    }

    private class Coupe {
        Rectangle z;
        int[][] pixels;

        Coupe(int x, int y, int width, int height, BufferedImage image) {
            this.z = new Rectangle(x, y, width, height);
            this.pixels = new int[width][height];

            for (int i = 0; i < width; i++)
                for (int j = 0; j < height; j++)
                    this.pixels[i][j] = image.getRGB(i, j);
        }

        void doit() {
            ImageEditModel.this.clearzone(z);
        }

        void undo() {
            ImageEditModel.this.fillzone(z, pixels);
        }
    }

    private class CutEdit extends AbstractUndoableEdit {
        Coupe c;

        public CutEdit(ImageEditModel.Coupe c) {
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

    public BufferedImage getImage() {
        return image;
    }

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

    public void clearzone(Rectangle z) {
        Color color = Color.white;
        int srgb = color.getRGB();

        for (int i = 0; i < z.getWidth(); i++)
            for (int j = 0; j < z.getHeight(); j++)
                image.setRGB((int) z.getX() + i, (int) z.getY() + j, srgb);
    }

    public void saveCut(Rectangle z) {

        BufferedImage subImage = image.getSubimage((int) z.getX(), (int) z.getY(), (int) z.getWidth(),
                (int) z.getHeight());
        Coupe c = new Coupe((int) z.getX(), (int) z.getY(), (int) z.getWidth(), (int) z.getHeight(), subImage);

        c.doit();

        CutEdit ce = new CutEdit(c);

        undoManager.addEdit(ce);
    }

}
