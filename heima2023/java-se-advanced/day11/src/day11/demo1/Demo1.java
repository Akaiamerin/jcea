package day11.demo1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Demo1 {
    public static void main(String[] args) {
        String srcPath = "./day11/src/day11/demo1/img1.jpg";
        String destPath = "./day11/src/day11/demo1/img2.jpg";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = bis.read(buf)) != -1) {
                bos.write(buf, 0, size);
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}