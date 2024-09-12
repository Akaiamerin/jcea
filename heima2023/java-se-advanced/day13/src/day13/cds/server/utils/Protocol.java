package day13.cds.server.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class Protocol {
    /**
     * 操作类型
     */
    public static class Type {
        public static final String SCAN = "scan"; //浏览
        public static final String UPLOAD = "upload"; //上传
        public static final String DOWNLOAD = "download"; //下载
    }
    /**
     * 操作状态
     */
    public static class Status {
        public static final String OK = "ok"; //成功
        public static final String FAILED = "failed"; //失败
    }
    private String type; //操作类型
    private String fileName; //操作文件
    private String status; //操作状态
    private String message; //操作信息
    public Protocol() {

    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        Field[] fieldArr = getClass().getDeclaredFields();
        StringBuilder strBld = new StringBuilder();
        for (int i = 0; i < fieldArr.length; i++) {
            Field field = fieldArr[i];
            field.setAccessible(true);
            try {
                strBld.append(field.getName()).append("=").append(field.get(this)).append(",");
            }
            catch (IllegalAccessException exc) {
                exc.printStackTrace();
            }
        }
        return strBld + System.lineSeparator();
    }
    /**
     * 获取浏览文件协议
     * @param path
     * @return
     */
    public static Protocol getScanProtocol(String path) {
        Protocol protocol = new Protocol();
        protocol.setType(Type.SCAN);
        protocol.setFileName(path);
        return protocol;
    }
    /**
     * 获取上传文件协议
     * @param file
     * @return
     */
    public static Protocol getUploadProtocol(File file) {
        Protocol protocol = new Protocol();
        protocol.setType(Type.UPLOAD);
        protocol.setFileName(file.getPath());
        return protocol;
    }
    /**
     * 获取下载文件协议
     * @param path
     * @return
     */
    public static Protocol getDownloadProtocol(String path) {
        Protocol protocol = new Protocol();
        protocol.setType(Type.DOWNLOAD);
        protocol.setFileName(path);
        return protocol;
    }
    /**
     * 解析协议
     * @param str
     * @return
     */
    public static Protocol parseProtocol(String str) {
        Map<String, String> map = new HashMap<>();
        String[] strArr = str.split(",");
        for (String elem : strArr) {
            String[] arr = elem.split("=", 2);
            map.put(arr[0], arr[1]);
        }
        Protocol protocol = new Protocol();
        Field[] declaredFieldArr = protocol.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFieldArr.length; i++) {
            Field field = declaredFieldArr[i];
            field.setAccessible(true);
            try {
                field.set(protocol, map.get(field.getName()));
            }
            catch (IllegalAccessException exc) {
                exc.printStackTrace();
            }
        }
        return protocol;
    }
    public static Protocol parseProtocol(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String protocolStr = br.readLine();
        return parseProtocol(protocolStr);
    }
}