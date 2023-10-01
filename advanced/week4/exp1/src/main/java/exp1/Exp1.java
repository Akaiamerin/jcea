package exp1;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
public class Exp1 {
    private static final String PATH1 = "./src/main/resources/tadokoro_kouji.jpg";
    private static final String PATH2 = "./src/main/resources/tadokoro_kouji_with_watermark.jpg";
    public static void generateWatermark(String watermark) {
        try {
            BufferedImage srcBufImg = ImageIO.read(new File(PATH1));
            int width = srcBufImg.getWidth();
            int height = srcBufImg.getHeight();
            BufferedImage destBufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D graph2D = destBufImg.createGraphics();
            graph2D.drawImage(srcBufImg, 0, 0, width, height, null);
            graph2D.setColor(Color.WHITE);
            graph2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            graph2D.setFont(new Font("微软雅黑", Font.PLAIN, 30));
            graph2D.drawString(watermark, width / 3, height / 2);
            graph2D.dispose();
            ImageIO.write(destBufImg, "jpg", new FileOutputStream(PATH2));
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        generateWatermark("114514");
    }
}