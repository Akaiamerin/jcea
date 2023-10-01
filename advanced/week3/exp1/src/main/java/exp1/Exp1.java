package exp1;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
public class Exp1 {
    public static void outputChineseMsg() {
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.CHINA);
        Enumeration<String> strEnum = bundle.getKeys();
        while (strEnum.hasMoreElements() == true) {
            String str = strEnum.nextElement();
            System.out.println(str + "=" + bundle.getString(str));
        }
    }
    public static void outputEnglishMsg() {
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.US);
        Enumeration<String> strEnum = bundle.getKeys();
        while (strEnum.hasMoreElements() == true) {
            String str = strEnum.nextElement();
            System.out.println(str + "=" + bundle.getString(str));
        }
    }
    public static void main(String[] args) {
        outputChineseMsg();
        outputEnglishMsg();
    }
}