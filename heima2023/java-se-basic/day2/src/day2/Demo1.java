package day2;
public class Demo1 {
    public static void main(String[] args) {
        int num = 1234;
        int onesDigit = num % 10;
        int tensDigit = num / 10 % 10;
        int hundredsDigit = num / 10 / 10 % 10;
        int thousandsDigit = num / 1000;
        System.out.println(onesDigit + tensDigit + hundredsDigit + thousandsDigit);
    }
}