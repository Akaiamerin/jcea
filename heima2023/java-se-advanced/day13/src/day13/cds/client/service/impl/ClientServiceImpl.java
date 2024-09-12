package day13.cds.client.service.impl;
import day13.cds.client.CloudDriveSystemClient;
import day13.cds.client.service.FileHandlerService;
import day13.cds.server.exception.BusinessException;
import day13.cds.client.service.ClientService;
import java.io.File;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
public class ClientServiceImpl implements ClientService {
    private FileHandlerService fileHandlerService = new FileHandlerServiceImpl();
    private void init() {
        ResourceBundle bundle = ResourceBundle.getBundle("day13/cds/client/config");
        String downloadPath = bundle.getString("downloadPath");
        File downloadDir = new File(downloadPath);
        if (downloadDir.isFile() == true) {
            throw new BusinessException("下载目录不能是文件");
        }
        else if (downloadDir.exists() == false && downloadDir.mkdirs() == false) {
            throw new BusinessException("下载目录初始化失败");
        }
    }
    @Override
    public void start() {
        init();
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("---云盘系统---");
                System.out.println("1、浏览当前目录");
                System.out.println("2、浏览子目录");
                System.out.println("3、返回上一级目录");
                System.out.println("4、下载文件");
                System.out.println("5、上传文件");
                System.out.println("6、退出");
                System.out.print("请输入操作命令：");
                String option = sc.nextLine();
                if (Objects.equals(option, "1") == true) {
                    fileHandlerService.scan(CloudDriveSystemClient.current);
                }
                else if (Objects.equals(option, "2") == true) {
                    System.out.print("请输入要浏览的子目录：");
                    String children = sc.nextLine();
                    fileHandlerService.scan(new File(CloudDriveSystemClient.current, children));
                }
                else if (Objects.equals(option, "3") == true) {
                    if (Objects.equals(CloudDriveSystemClient.current.getName(), "root") == true) {
                        System.out.println("当前为根目录");
                    }
                    else {
                        fileHandlerService.scan(CloudDriveSystemClient.current.getParentFile());
                    }
                }
                else if (Objects.equals(option, "4") == true) {
                    System.out.print("请输入要下载的文件名（含后缀）：");
                    String fileName = sc.nextLine();
                    fileHandlerService.download(new File(CloudDriveSystemClient.current, fileName));
                }
                else if (Objects.equals(option, "5") == true) {
                    while (true) {
                        System.out.print("请输入要上传的文件（绝对路径）：");
                        String uploadPath = sc.nextLine();
                        File uploadFile = new File(uploadPath);
                        if (uploadFile.exists() == false) {
                            System.out.println("文件不存在");
                        }
                        else if (uploadFile.isDirectory() == true) {
                            System.out.println("目录不支持上传");
                        }
                        else if (uploadFile.isFile() == true) {
                            fileHandlerService.upload(uploadFile);
                            break;
                        }
                    }
                }
                else if (Objects.equals(option, "6") == true) {
                    sc.close();
                    System.exit(0);
                }
                else {
                    System.out.println("命令错误");
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}