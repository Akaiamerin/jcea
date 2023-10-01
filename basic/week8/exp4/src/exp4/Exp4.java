package exp4;
import java.util.Scanner;
public class Exp4 {
    public static int[] getDate(String str) {
        String[] dateStr = str.split("/");
        int[] date = new int[dateStr.length]; //年、月、日
        for (int i = 0; i < date.length; i++) {
            date[i] = Integer.parseInt(dateStr[i]);
        }
        return date;
    }
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
    //某年过了多少天
    public static int daySum(int[] date) {
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(date[0]) == true) {
            month[2] = 29;
        }
        int sumDay = 0;
        for (int i = 1; i < date[1]; i++) {
            sumDay += month[i];
        }
        sumDay += date[2];
        return sumDay;
    }
    //日期差
    public static int getDiffDate(int[] beginDate, int[] endDate) {
        int ret = 0;
        //年份相同
        if (beginDate[0] == endDate[0]) {
            ret = daySum(endDate) - daySum(beginDate);
        }
        else {
            if (isLeapYear(beginDate[0]) == true) {
                ret += 366 - daySum(beginDate);
            }
            else {
                ret += 365 - daySum(beginDate);
            }
            ret += daySum(endDate);
            for (int i = beginDate[0] + 1; i < endDate[0]; i++) {
                if (isLeapYear(i) == true) {
                    ret += 366;
                }
                else {
                    ret += 365;
                }
            }
        }
        return ret;
    }
    public static boolean judge(int[] beginDate, int[] endDate) {
        int diffDate = getDiffDate(beginDate, endDate) % 5;
        //打渔：[0, 1, 2] 晒网：[3, 4]
        if (diffDate >= 0 && diffDate <= 2) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("开始“三天打鱼两天晒网”日期");
        String beginStr = sc.next();
        int[] beginDate = getDate(beginStr);
        System.out.println("结束“三天打鱼两天晒网”日期");
        String endStr = sc.next();
        int[] endDate = getDate(endStr);
        if (judge(beginDate, endDate) == true) {
            System.out.println(endStr + "是打渔日");
        }
        else {
            System.out.println(endStr + "是晒网日");
        }
        sc.close();
    }
}
/*
1990/1/1
2022/2/22
*/