package day8.demo2;
import java.util.Scanner;
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int num = sc.nextInt();
        try {
            if (num < 1 || num > 7) {
                throw new Exception("输入错误！");
            }
            else {
                System.out.println(arr[num % arr.length]);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}