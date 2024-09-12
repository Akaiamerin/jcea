package day10.demo4;
import java.io.FileInputStream;
import java.io.IOException;
public class Demo4 {
    public static void read1(String path) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int data = -1;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
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
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void read2(String path) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = fis.read(buf)) != -1) {
                System.out.println(new String(buf, 0, size));
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
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String path = "./day10/src/day10/demo4/file.txt";
        read1(path);
        System.out.println();
        read2(path);
    }
}