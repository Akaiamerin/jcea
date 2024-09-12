package day3;
public class Demo1 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 3 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        sum = 0;
        int i = 1;
        while (i <= 10) {
            if (i % 3 != 0) {
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }
}