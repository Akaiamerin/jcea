package day12.demo6;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.UUID;
public class Client {
    public static void main(String[] args) {
        String path = "./day12/src/day12/demo6/img" + String.valueOf(UUID.randomUUID()).substring(0, 6) + ".jpg";
        Socket socket = null;
        FileOutputStream fos = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            InputStream is = socket.getInputStream();
            fos = new FileOutputStream(path);
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = is.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            socket.shutdownInput();
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}