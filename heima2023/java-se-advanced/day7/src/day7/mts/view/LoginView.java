package day7.mts.view;
import day7.mts.MovieTicketingSystem;
import day7.mts.pojo.Business;
import day7.mts.pojo.Customer;
import day7.mts.pojo.User;
import java.util.Objects;
public class LoginView {
    private LoginView() {

    }
    public static void view() {
        while (true) {
            System.out.print("请输入用户名：");
            String username = MovieTicketingSystem.SC.nextLine();
            System.out.print("请输入密码：");
            String password = MovieTicketingSystem.SC.nextLine();
            User user = MovieTicketingSystem.ALL_USER.get(username);
            if (user != null) {
                if (Objects.equals(password, user.getPassWord()) == true) {
                    if (user instanceof Business) {
                        BusinessView.indexView(user);
                    }
                    else if (user instanceof Customer) {
                        CustomerView.indexView(user);
                    }
                    return;
                }
                else {
                    System.out.println("用户名或密码错误");
                }
            }
            else {
                System.out.println("用户名或密码错误");
            }
        }
    }
}