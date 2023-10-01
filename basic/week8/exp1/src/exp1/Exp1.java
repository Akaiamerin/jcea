package exp1;
import java.util.Scanner;
public class Exp1 {
    public static int[] chCnt(String str) {
        int[] ret = new int[3];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ret[0]++;
            }
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ret[1]++;
            }
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                ret[2]++;
            }
        }
        return ret;
    }
    public static int substrCnt(String str, String substr) {
        int ret = 0;
        int substrIndex = 0;
        while ((substrIndex = str.indexOf(substr)) != -1) {
            str = str.substring(substrIndex + substr.length());
            ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        int[] cnt = chCnt(str1);
        System.out.println("数字：" + cnt[0]);
        System.out.println("小写字母：" + cnt[1]);
        System.out.println("大写字母：" + cnt[2]);
        String str2 = "asdq56wfhellohelloer8tyhellofbhelloy7jthellofyjunkjkhellort345hello";
        String substr2 = "hello";
        System.out.println(str2);
        System.out.println(substr2 + "出现的次数：" + substrCnt(str2, substr2));
        sc.close();
    }
}