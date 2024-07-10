package exp1;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface LoginMethodAnnotation {
    String username() default "admin";
    String password() default "111111";
}
class Login {
    private String username;
    private String password;
    public Login() {

    }
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    @LoginMethodAnnotation(username = "张三")
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    @LoginMethodAnnotation(password = "333333")
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return username + " " + password;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Login login = new Login();
        try {
            Method method1 = login.getClass().getDeclaredMethod("setUsername", String.class);
            if (method1.isAnnotationPresent(LoginMethodAnnotation.class) == true) {
                LoginMethodAnnotation annotation = method1.getAnnotation(LoginMethodAnnotation.class);
                method1.invoke(login, annotation.username());
            }
            Method method2 = login.getClass().getDeclaredMethod("setPassword", String.class);
            if(method2.isAnnotationPresent(LoginMethodAnnotation.class) == true){
                LoginMethodAnnotation annotation = method2.getAnnotation(LoginMethodAnnotation.class);
                method2.invoke(login, annotation.password());
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println(login);
    }
}