package day4.demo3;
import java.util.Scanner;
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入性别：");
        String gender = sc.next();
        System.out.print("请输入年龄：");
        String age = sc.next();
        System.out.print("请输入身高：");
        String height = sc.next();
        System.out.print("请输入婚否：");
        String isMarried = sc.next();
        Employee employee = new Employee(name, gender.charAt(0), Integer.parseInt(age), Double.parseDouble(height), Boolean.parseBoolean(isMarried));
        System.out.println(employee);
        sc.close();
    }
}