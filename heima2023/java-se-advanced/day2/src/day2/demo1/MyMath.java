package day2.demo1;
public final class MyMath {
    public static final double PI = 3.14;
    private MyMath() {

    }
    public static int getMin(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        }
        return num2;
    }
    public static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }
}