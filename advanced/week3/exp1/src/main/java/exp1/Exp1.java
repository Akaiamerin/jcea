package exp1;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
public class Exp1 {
    public static void outputChineseMsg() {
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.CHINA);
        Enumeration<String> keyEnum = bundle.getKeys();
        while (keyEnum.hasMoreElements() == true) {
            String key = keyEnum.nextElement();
            System.out.println(key + "=" + bundle.getString(key));
        }
    }
    public static void outputEnglishMsg() {
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.US);
        Enumeration<String> keyEnum = bundle.getKeys();
        while (keyEnum.hasMoreElements() == true) {
            String key = keyEnum.nextElement();
            System.out.println(key + "=" + bundle.getString(key));
        }
    }
    public static void main(String[] args) {
        outputChineseMsg();
        outputEnglishMsg();
    }
}