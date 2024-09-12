package day4;
public class Demo1 {
    public static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }
    public static void main(String[] args) {
        System.out.println(getMax(1, 2));
    }
}