package day12.demo2;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
public class Demo2 {
    public static void main(String[] args) {
        String path = "./day12/src/day12/demo2/file.txt";
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一行字符串：");
        String str = sc.nextLine();
        PrintStream ps = null;
        try {
            ps = new PrintStream(path);
            ps.println(str);
        }
        catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
        finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}