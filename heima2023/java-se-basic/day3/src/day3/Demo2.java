package day3;
public class Demo2 {
    public static void main(String[] args) {
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                sum += i;
                cnt++;
            }
        }
        System.out.println(sum + " " + cnt);
        sum = 0;
        cnt = 0;
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 1) {
                sum += i;
                cnt++;
            }
            i++;
        }
        System.out.println(sum + " " + cnt);
    }
}