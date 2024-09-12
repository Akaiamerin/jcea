package day13.cds.client;
import day13.cds.client.service.ClientService;
import day13.cds.client.service.impl.ClientServiceImpl;
import java.io.File;
public class CloudDriveSystemClient {
    public static File current = new File("root");
    public static void main(String[] args) {
        ClientService service = new ClientServiceImpl();
        service.start();
    }
}