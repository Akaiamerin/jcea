package day8.demo4;
import java.util.Objects;
public class Demo4 {
    public static void login(String username, String password) throws LoginException {
        if (Objects.equals("admin", username) == false) {
            throw new LoginException("用户名不存在");
        }
        if (Objects.equals("111111", password) == false) {
            throw new LoginException("密码错误");
        }
        if (Objects.equals("admin", username) == true && Objects.equals("111111", password) == true) {
            System.out.println("欢迎" + username);
        }
    }
    public static void main(String[] args) {
        try {
            login("admin", "111111");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}