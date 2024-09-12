package day10.demo3;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Demo3 {
    private static void show(String path) {
        File file = new File(path);
        if (file.exists() == false) {
            try {
                file.createNewFile();
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        System.out.println("文件名：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("父级目录：" + file.getParent());
        System.out.println("文件大小：" + file.length());
        System.out.println("文件后缀名：" + file.getName().substring(file.getName().lastIndexOf(".") + 1));
    }
    public static void main(String[] args) {
        //./day10/src/day10/demo3/file.txt
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String path = sc.nextLine();
        show(path);
        sc.close();
    }
}