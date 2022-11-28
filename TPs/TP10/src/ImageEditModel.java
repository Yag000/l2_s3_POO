import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageEditModel {

    BufferedImage image;

    public ImageEditModel(String chemin) {
        try {
            this.image = ImageIO.read(new File(chemin));
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de l'image");
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void fillzone(Rectangle z, int[][] pixels) {

        if (z.getHeight() != pixels.length)
            throw new IllegalArgumentException("La zone et le tableau ne sont pas de la même taille");

        for (int[] ligne : pixels)
            if (z.getWidth() != ligne.length)
                throw new IllegalArgumentException("La zone et le tableau ne sont pas de la même taille");

        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                image.setRGB((int) z.getX() + i, (int) z.getY() + j, pixels[i][j]);
    }

    public void clearzone(Rectangle z) {
        Color color = Color.white;
        int srgb = color.getRGB();

        for (int i = 0; i < z.getWidth(); i++)
            for (int j = 0; j < z.getHeight(); j++)
                image.setRGB((int) z.getX() + i, (int) z.getY() + j, srgb);
    }

}
