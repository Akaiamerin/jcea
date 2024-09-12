package day12.demo5;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        String path = "./day12/src/day12/demo5/img.jpg";
        Socket socket = null;
        FileInputStream fis = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            OutputStream os = socket.getOutputStream();
            fis = new FileInputStream(path);
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = fis.read(buf)) != -1) {
                os.write(buf, 0, size);
            }
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            while ((size = is.read(buf)) != -1) {
                System.out.println("服务端发送的数据：" + new String(buf, 0, size));
            }
            socket.shutdownInput();
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
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