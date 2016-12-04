import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 12/4/2016.
 */
public class imageProcesses {

    public boolean[][] convetBufferedImageToBooleanArray(BufferedImage image){
        int[] pixel;
        boolean[][] message = new boolean[image.getWidth()][image.getHeight()];
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                pixel = image.getRaster().getPixel(x, y, new int[4]);
                if(pixel[0] == 0) message[x][y] = true;
                else message[x][y] = false;
            }
        }

        return message;
    }

    public BufferedImage convertBooleanArrayToBufferedImage(boolean[][] messageImage){
        BufferedImage image = new BufferedImage(messageImage.length, messageImage[0].length, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < messageImage[0].length; y++) {
            for (int x = 0; x < messageImage.length; x++) {

                if(messageImage[x][y])
                    image.setRGB(x,y,new Color(0,0,0,255).getRGB());
                else image.setRGB(x,y,new Color(255,255,255,255).getRGB());
            }
        }

        return image;
    }

    public void createImage(String name, BufferedImage image) throws IOException {
        String path = "D:\\college\\computer and network security\\labs\\images\\"+ name +".png";
        File imageFile = new File(path);
        ImageIO.write(image, "png", imageFile);
    }
}
