package day12.demo5;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;
public class UploadTask implements Runnable {
    private Socket socket;
    public UploadTask(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        String path = "./day12/src/day12/demo5/img" + String.valueOf(UUID.randomUUID()).substring(0, 6) + ".jpg";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[8192];
            int size = -1;
            while ((size = is.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            socket.shutdownInput();
            OutputStream os = socket.getOutputStream();
            os.write("上传成功".getBytes());
            socket.shutdownOutput();
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
}