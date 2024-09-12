package day13.cds.server;
import day13.cds.server.service.ServerService;
import day13.cds.server.service.impl.ServerServiceImpl;
public class CloudDriveSystemServer {
    public static void main(String[] args) {
        ServerService service = new ServerServiceImpl();
        service.start();
    }
}