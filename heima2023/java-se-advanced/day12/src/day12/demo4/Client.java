package day12.demo4;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            OutputStream os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[8192];
            int size = -1;
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