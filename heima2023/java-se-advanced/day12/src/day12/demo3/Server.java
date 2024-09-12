package day12.demo3;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9999);
            socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[8192];
            int size = is.read(buf);
            System.out.println("客户端发送的数据：" + new String(buf, 0, size));
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
                if (serverSocket != null) {
                    serverSocket.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}