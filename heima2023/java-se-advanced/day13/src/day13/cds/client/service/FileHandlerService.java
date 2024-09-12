package day13.cds.client.service;
import java.io.File;
public interface FileHandlerService {
    /**
     * 浏览文件
     */
    void scan(File file);
    /**
     * 上传文件
     */
    void upload(File file);
    /**
     * 下载文件
     */
    void download(File file);
}