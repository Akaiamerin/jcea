package day10.demo5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Demo5 {
    public static void main(String[] args) {
        String srcPath = "./day10/src/day10/demo5/img1.jpg";
        String destPath = "./day10/src/day10/demo5/img2.jpg";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = fis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}