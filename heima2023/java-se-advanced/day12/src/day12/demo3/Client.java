package day12.demo3;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            OutputStream os = socket.getOutputStream();
            os.write("你好，世界！".getBytes());
            socket.shutdownOutput();
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