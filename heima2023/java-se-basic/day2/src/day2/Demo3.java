package day2;
public class Demo3 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int maxNum = num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3);
        System.out.println(maxNum);
        if (num1 > num2 && num1 > num3) {
            maxNum = num1;
        }
        else if (num2 > num1 && num2 > num3) {
            maxNum = num2;
        }
        else if (num3 > num1 && num3 > num2) {
            maxNum = num3;
        }
        System.out.println(maxNum);
    }
}