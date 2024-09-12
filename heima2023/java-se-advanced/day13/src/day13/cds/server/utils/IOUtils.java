package day13.cds.server.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class IOUtils {
    private IOUtils() {

    }
    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[8192];
        int size = -1;
        while ((size = is.read(buf)) != -1) {
            os.write(buf, 0, size);
        }
    }
}