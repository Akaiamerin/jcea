package day3;
public class Demo3 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i % 3 == 0 && i % 5 == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}