package day13.cds.client.service.impl;
import day13.cds.client.CloudDriveSystemClient;
import day13.cds.client.service.FileHandlerService;
import day13.cds.server.utils.Protocol;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Objects;
import java.util.ResourceBundle;
public class FileHandlerServiceImpl implements FileHandlerService {
    private int port;
    public FileHandlerServiceImpl() {
        ResourceBundle bundle = ResourceBundle.getBundle("day13/cds/client/config");
        port = Integer.parseInt(bundle.getString("clientPort"));
    }
    @Override
    public void scan(File file) {
        try (
                Socket socket = new Socket("127.0.0.1", port);
                OutputStream os = socket.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            Protocol scanProtocol = Protocol.getScanProtocol(file.getPath());
            os.write(String.valueOf(scanProtocol).getBytes());
            String protocolStr = br.readLine();
            Protocol protocol = Protocol.parseProtocol(protocolStr);
            String content = null;
            if (Objects.equals(protocol.getStatus(), Protocol.Status.OK) == true) {
                CloudDriveSystemClient.current = new File(protocol.getFileName());
                System.out.println("当前目录：" + CloudDriveSystemClient.current);
                while ((content = br.readLine()) != null) {
                    System.out.println(content);
                }
            }
            else {
                System.out.println(protocol.getMessage());
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    @Override
    public void upload(File file) {
        System.out.println("待完成！");
    }
    @Override
    public void download(File file) {
        System.out.println("待完成！");
    }
}