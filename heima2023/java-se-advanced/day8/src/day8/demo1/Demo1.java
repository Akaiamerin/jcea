package day8.demo1;
import java.util.Scanner;
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入被除数：");
        int dividend = sc.nextInt();
        System.out.print("请输入除数：");
        int divisor = sc.nextInt();
        try {
            int result = dividend / divisor;
            System.out.println(dividend + " / " + divisor + " = " + result);
        }
        catch (ArithmeticException exc) {
            if (divisor == 0) {
                System.out.println("除数不能为 0！");
            }
        }
    }
}