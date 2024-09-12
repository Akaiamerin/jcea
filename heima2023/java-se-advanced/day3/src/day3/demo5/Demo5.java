package day3.demo5;
import java.time.LocalDate;
import java.util.Scanner;
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = sc.nextInt();
        System.out.println(LocalDate.of(year, 2, 1).lengthOfMonth());
        sc.close();
    }
}