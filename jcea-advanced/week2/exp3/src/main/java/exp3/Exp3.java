package exp3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Exp3 {
    public static boolean verifyEmail(String str) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)+$");
        Matcher emailMatcher = emailPattern.matcher(str);
        return emailMatcher.matches();
    }
    public static boolean verifyTel(String str) {
        Pattern telPattern = Pattern.compile("^1[3-9][0-9]{9}$");
        Matcher telMatcher = telPattern.matcher(str);
        return telMatcher.matches();
    }
    public static boolean verifyQQ(String str) {
        Pattern qqPattern = Pattern.compile("^[1-9][0-9]{5,10}$");
        Matcher qqMatcher = qqPattern.matcher(str);
        return qqMatcher.matches();
    }
}