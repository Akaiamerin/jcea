package day3.demo3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入生日（yyyy-MM-dd）：");
        String str = sc.nextLine();
        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (birthday.isAfter(now)) {
            System.out.println("生日必须早于当前日期！");
        }
        else {
            System.out.println("来到世界 " + birthday.until(now, ChronoUnit.DAYS) + " 天");
        }
        sc.close();
    }
}