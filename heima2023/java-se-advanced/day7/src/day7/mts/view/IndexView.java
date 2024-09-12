package day7.mts.view;
import day7.mts.MovieTicketingSystem;
import java.util.Objects;
public class IndexView {
    private IndexView() {

    }
    public static void view() {
        while (true) {
            System.out.println("---首页---");
            System.out.println("1、登录");
            System.out.println("2、客户注册");
            System.out.println("3、商家注册");
            System.out.println("4、退出");
            System.out.print("请输入操作命令：");
            String option = MovieTicketingSystem.SC.nextLine();
            if (Objects.equals(option, "1") == true) {
                LoginView.view();
            }
            else if (Objects.equals(option, "2") == true) {
                CustomerView.registerView();
            }
            else if (Objects.equals(option, "3") == true) {
                BusinessView.registerView();
            }
            else if (Objects.equals(option, "4") == true) {
                MovieTicketingSystem.SC.close();
                System.exit(0);
            }
            else {
                System.out.println("命令错误");
            }
        }
    }
}