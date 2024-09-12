package day12.demo4;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                System.out.println("等待客户端连接");
                socket = serverSocket.accept();
                System.out.println("客户端连接成功");
                InputStream is = socket.getInputStream();
                byte[] buf = new byte[8192];
                int size = -1;
                while ((size = is.read(buf)) != -1) {
                    System.out.println("客户端发送的数据：" + new String(buf, 0, size));
                }
                socket.shutdownInput();
                OutputStream os = socket.getOutputStream();
                os.write("我是服务端".getBytes());
                socket.shutdownOutput();
            }
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