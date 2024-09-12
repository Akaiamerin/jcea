package day12.demo6;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class DownloadThread implements Runnable {
    private Socket socket;
    public DownloadThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        String path = "./day12/src/day12/demo6/img.jpg";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            OutputStream os = socket.getOutputStream();
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = fis.read(buf)) != -1) {
                os.write(buf, 0, size);
            }
            socket.shutdownOutput();
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
}