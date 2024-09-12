package day10.demo6;
import java.io.FileOutputStream;
import java.io.IOException;
public class Demo6 {
    public static void write1(String path, String content) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(content.getBytes());
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void write2(String path, String content) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(content.getBytes());
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String path = "./day10/src/day10/demo6/file.txt";
        write1(path, "Hello World!");
        write2(path, "Hello World!");
    }
}