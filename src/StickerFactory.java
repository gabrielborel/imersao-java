import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerFactory {

   public void generate(InputStream inputStream, String fileName) throws Exception {
      //InputStream inputStream = new FileInputStream(new File("src/assets/movie.jpg"));
      //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();

      BufferedImage originalImage = ImageIO.read(inputStream);
      int originalWidth = originalImage.getWidth();
      int originalHeight = originalImage.getHeight();
      int newHeight = originalHeight + 200;

      var newImage = new BufferedImage(originalWidth, newHeight, BufferedImage.TRANSLUCENT);

      Graphics2D graphics = (Graphics2D) newImage.getGraphics();
      graphics.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 100));
      graphics.setColor(Color.yellow);
      graphics.drawString("TOPZERA", 100, (newHeight - 90));
      graphics.drawImage(originalImage, 0, 0, null);

      ImageIO.write(newImage, "png", new File(fileName));
   }

}
