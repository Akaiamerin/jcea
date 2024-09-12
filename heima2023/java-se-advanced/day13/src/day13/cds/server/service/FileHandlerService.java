package day13.cds.server.service;
import day13.cds.server.utils.Protocol;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public interface FileHandlerService {
    /**
     * 浏览文件
     * @param protocol
     * @param is
     * @param os
     * @throws IOException
     */
    void scan(Protocol protocol, InputStream is, OutputStream os) throws IOException;
    /**
     * 上传文件
     * @param protocol
     * @param is
     * @param os
     * @throws IOException
     */
    void upload(Protocol protocol, InputStream is, OutputStream os) throws IOException;
    /**
     * 下载文件
     * @param protocol
     * @param is
     * @param os
     * @throws IOException
     */
    void download(Protocol protocol, InputStream is, OutputStream os) throws IOException;
}