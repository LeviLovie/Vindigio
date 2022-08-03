import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Text {
    public BufferedImage[] result_images = new BufferedImage[64];
    public void text_parser(String text_in) {
        char[] result = text_in.toCharArray();

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'Т' || result[i] == 'т') {
                try {this.result_images[i] = ImageIO.read(new File("src/Tekst_tiles/т.png"));} catch (IOException ignored) {System.out.println("tile not found");}
            } else if (result[i] == 'Е' || result[i] == 'е') {
                try {this.result_images[i] = ImageIO.read(new File("src/Tekst_tiles/е.png"));} catch (IOException ignored) {System.out.println("tile not found");}
            } else if (result[i] == 'С' || result[i] == 'с') {
                try {this.result_images[i] = ImageIO.read(new File("src/Tekst_tiles/с.png"));} catch (IOException ignored) {System.out.println("tile not found");}
            }
        }

        System.out.println(result[0]);
    }
}
