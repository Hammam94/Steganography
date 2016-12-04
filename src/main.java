import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 12/3/2016.
 */
public class main {

    public static void main(String[] args) throws IOException {

        Steganography steganography = new Steganography();
        imageProcesses imageProcesses = new imageProcesses();

        //hide message
        Image source = ImageIO.read(new File("D:\\college\\computer and network security\\labs\\o.png"));
        BufferedImage messageImage = ImageIO.read(new File("D:\\college\\computer and network security\\labs\\m.png"));
        Image newSource = steganography.hideMessage(imageProcesses.convetBufferedImageToBooleanArray(messageImage), source);
        imageProcesses.createImage("saved", (BufferedImage)newSource);

        //get message
        Image source1 = ImageIO.read(new File("D:\\college\\computer and network security\\labs\\Test cases\\101010.png"));
        boolean[][] messageImage1 = steganography.findMessage(source1);
        imageProcesses.createImage("saved10",imageProcesses.convertBooleanArrayToBufferedImage(messageImage1));
    }
}
