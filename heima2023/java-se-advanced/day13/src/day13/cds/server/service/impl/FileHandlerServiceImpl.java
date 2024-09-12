package day13.cds.server.service.impl;
import day13.cds.server.exception.BusinessException;
import day13.cds.server.service.FileHandlerService;
import day13.cds.server.utils.Protocol;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.ResourceBundle;
public class FileHandlerServiceImpl implements FileHandlerService, Runnable {
    private Socket socket;
    private File root;
    public FileHandlerServiceImpl(Socket socket) {
        this.socket = socket;
        ResourceBundle bundle = ResourceBundle.getBundle("day13/cds/server/config");
        root = new File(bundle.getString("rootDir"));
        if (root.isFile() == true) {
            throw new BusinessException("根目录已存在");
        }
        else if (root.exists() == false && root.mkdirs() == false) {
            throw new BusinessException("根目录创建失败");
        }
    }
    @Override
    public void scan(Protocol protocol, InputStream is, OutputStream os) throws IOException {
        Protocol respProtocol = new Protocol();
        String fileName = protocol.getFileName();
        String dirPath = fileName.replace("root", String.valueOf(root));
        File dir = new File(dirPath);
        System.out.println(dirPath);
        if (dir.isDirectory() == false) {
            respProtocol.setType(Protocol.Type.SCAN);
            respProtocol.setStatus(Protocol.Status.FAILED);
            respProtocol.setMessage("目录不存在");
            String protocolStr = String.valueOf(respProtocol);
            System.out.println("服务端响应的数据：" + protocolStr);
            os.write(protocolStr.getBytes());
        }
        else {
            respProtocol.setType(Protocol.Type.SCAN);
            respProtocol.setFileName(protocol.getFileName());
            respProtocol.setStatus(Protocol.Status.OK);
            String protocolStr = String.valueOf(respProtocol);
            System.out.println("服务端响应的数据：" + protocolStr);
            os.write(protocolStr.getBytes());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            File[] children = Objects.requireNonNullElse(dir.listFiles(), new File[]{});
            for (int i = 0; i < children.length; i++) {
                File child = children[i];
                if (child.isFile() == true) {
                    bw.write("文件 " + child.getName());
                    bw.newLine();
                }
                else {
                    bw.write("目录 " + child.getName());
                    bw.newLine();
                }
                bw.flush();
            }
        }
    }
    @Override
    public void upload(Protocol protocol, InputStream is, OutputStream os) throws IOException {
        System.out.println("待完成！");
        String fileName = protocol.getFileName().replace("root", String.valueOf(root));
    }
    @Override
    public void download(Protocol protocol, InputStream is, OutputStream os) throws IOException {
        System.out.println("待完成！");
        String fileName = protocol.getFileName().replace("root", String.valueOf(root));
    }
    @Override
    public void run() {
        try (
                Socket socket = this.socket;
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream()
        ) {
            Protocol protocol = Protocol.parseProtocol(is);
            System.out.println("客户端发送的数据：" + protocol);
            String type = protocol.getType();
            if (Objects.equals(type, Protocol.Type.SCAN) == true) {
                scan(protocol, is, os);
            }
            else if (Objects.equals(type, Protocol.Type.UPLOAD) == true) {
                upload(protocol, is, os);
            }
            else if (Objects.equals(type, Protocol.Type.DOWNLOAD) == true) {
                download(protocol, is, os);
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}