package exp1;
import java.util.Objects;
import java.util.Scanner;
class Account {
    private String username;
    private String password;
    private String name;
    private Double principal;
    public Account() {

    }
    public Account(String username, String name, Double principal) {
        this.username = username;
        this.password = "111111";
        this.name = name;
        this.principal = principal;
    }
    public Account(String username, String password, String name, Double principal) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.principal = principal;
    }
    public void deposit(Scanner sc) {
        while (true) {
            System.out.print("请输入密码：");
            String inputPassword = sc.nextLine();
            if (Objects.equals(inputPassword, password) == true) {
                System.out.print("请输入存款金额：");
                double money = sc.nextDouble();
                if (money <= 0) {
                    System.out.println("输入金额错误");
                }
                else {
                    principal += money;
                    System.out.println("账户余额：" + principal + "元");
                }
                break;
            }
            else {
                System.out.println("密码错误，请重新输入");
            }
        }
    }
    public void withdraw(Scanner sc) {
        while (true) {
            System.out.print("请输入密码：");
            String inputPassword = sc.nextLine();
            if (Objects.equals(inputPassword, password) == true) {
                System.out.print("请输入取款金额：");
                double money = sc.nextDouble();
                if (money > principal) {
                    System.out.println("输入金额错误，超出" + (money - principal) + "元");
                }
                else {
                    principal -= money;
                    System.out.println("账户余额：" + principal + "元");
                }
                break;
            }
            else {
                System.out.println("密码错误，请重新输入");
            }
        }
    }
    @Override
    public String toString() {
        return username + " " +
                password + " " +
                name + " " +
                principal;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account1 = new Account("333", "张三", 3333.0);
        System.out.println(account1);
        Account account2 = new Account("444", "444444", "李四", 4444.0);
        System.out.println(account2);
        sc.close();
    }
}