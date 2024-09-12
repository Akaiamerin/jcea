package day13.cds.server.service.impl;
import day13.cds.server.exception.BusinessException;
import day13.cds.server.service.ServerService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ServerServiceImpl implements ServerService {
    private ServerSocket serverSocket; //服务端对象
    private ExecutorService threadPool; //线程池
    private void init() {
        ResourceBundle bundle = ResourceBundle.getBundle("day13/cds/server/config");
        int port = Integer.parseInt(bundle.getString("serverPort"));
        try {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException exc) {
            throw new BusinessException("创建端口失败", exc);
        }
        threadPool = Executors.newFixedThreadPool(10);
    }
    @Override
    public void start() {
        init();
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                threadPool.submit(new FileHandlerServiceImpl(socket)); //使用线程池统一处理
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}