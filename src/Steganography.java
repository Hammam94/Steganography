import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/3/2016.
 */
public class Steganography {



    public Image hideMessage(boolean[][] message, Image source) {
        BufferedImage sourceImage = (BufferedImage) source;
        int[] pixel;

        for (int y = 0; y < sourceImage.getHeight(); y++) {
            for (int x = 0; x < sourceImage.getWidth(); x++) {
                pixel = sourceImage.getRaster().getPixel(x, y, new int[3]);
                if(pixel[0] % 2 == 0 && message[x][y]) pixel[0]++;
                else if(pixel[0] % 2 != 0&& !message[x][y] ) pixel[0]--;
                sourceImage.setRGB(x,y,new Color(pixel[0],pixel[1], pixel[2]).getRGB());
            }
        }
        return (Image) sourceImage;
    }
    public boolean [][] findMessage( Image modified) {
        BufferedImage messageImage = (BufferedImage) modified;
        boolean[][] message = new boolean[messageImage.getWidth()][messageImage.getHeight()];
        int[] pixel;
        for (int y = 0; y < messageImage.getHeight(); y++) {
            for (int x = 0; x < messageImage.getWidth(); x++) {
                pixel = messageImage.getRaster().getPixel(x, y, new int[3]);
                if(pixel[0] % 2 != 0) message[x][y] = true;
                else message[x][y] = false;
            }
        }

        return message;
    }
}
