package exp3;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Exp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)+$");
        Matcher emailMatcher = emailPattern.matcher(str);
        Pattern telPattern = Pattern.compile("^1[3-9][0-9]{9}$");
        Matcher telMatcher = telPattern.matcher(str);
        if (emailMatcher.matches() == true) {
            System.out.println("合法邮箱");
        }
        else if (telMatcher.matches() == true) {
            System.out.println("合法手机号");
        }
        else {
            System.out.println("非法邮箱或手机号");
        }
        sc.close();
    }
}