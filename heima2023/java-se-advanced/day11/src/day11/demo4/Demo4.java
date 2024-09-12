package day11.demo4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Demo4 {
    public static void write(String path, String str) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(path), "GB18030");
            osw.write(str);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void read(String path) {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream(path), "GB18030");
            char[] buf = new char[8192];
            int size = -1;
            while ((size = isr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, size));
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String path = "./day11/src/day11/demo4/file.txt";
        write(path, "你好，世界！");
        read(path);
    }
}