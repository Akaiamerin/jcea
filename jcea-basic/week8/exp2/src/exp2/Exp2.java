package exp2;
import java.util.Scanner;
class Rational {
    private Integer numerator;
    private Integer denominator;
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    public Rational(Integer numerator, Integer denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("分母不能为 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Integer getNumerator() {
        return numerator;
    }
    public Integer getDenominator() {
        return denominator;
    }
    public int greatestCommonDivisor(Integer num1, Integer num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        return greatestCommonDivisor(num2, num1 % num2);
    }
    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        if (denominator < 0) {
            return "-" + numerator + "/" + Math.abs(denominator);
        }
        if (numerator < 0 && denominator < 0) {
            return Math.abs(numerator) + "/" + Math.abs(denominator);
        }
        return numerator + "/" + denominator;
    }
    public Rational plus(Rational rational) throws Exception {
        numerator *= rational.denominator;
        rational.numerator *= denominator;
        int gcd = greatestCommonDivisor(numerator + rational.numerator, denominator * rational.denominator);
        Rational result = new Rational((numerator + rational.numerator) / gcd, denominator * rational.denominator / gcd);
        return result;
    }
    public Rational minus(Rational rational) throws Exception {
        numerator *= rational.denominator;
        rational.numerator *= denominator;
        int gcd = greatestCommonDivisor(numerator - rational.numerator, denominator * rational.denominator);
        Rational result = new Rational((numerator - rational.numerator) / gcd, denominator * rational.denominator / gcd);
        return result;
    }
    public Rational mul(Rational rational) throws Exception {
        int gcd = greatestCommonDivisor(numerator * rational.numerator, denominator * rational.denominator);
        Rational result = new Rational(numerator * rational.numerator / gcd, denominator * rational.denominator / gcd);
        return result;
    }
    public Rational div(Rational rational) throws Exception {
        int gcd = greatestCommonDivisor(numerator * rational.denominator, denominator * rational.numerator);
        Rational result = new Rational(numerator * rational.denominator / gcd, denominator * rational.numerator / gcd);
        return result;
    }
}
public class Exp2 {
    public static void Calc(String str) {
        char operCh = str.charAt(4);
        String[] strNum = str.split("/|\\D\\D\\D");
        int[] num = new int[strNum.length]; //[0]分子1 [1]分母1 [2]分子2 [3]分母2
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(strNum[i]);
        }
        try {
            Rational ration1 = new Rational(num[0], num[1]);
            Rational ration2 = new Rational(num[2], num[3]);
            if (operCh == '+') {
                System.out.println(str + " = " + ration1.plus(ration2));
            }
            else if (operCh == '-') {
                System.out.println(str + " = " + ration1.minus(ration2));
            }
            else if (operCh == '*') {
                System.out.println(str + " = " + ration1.mul(ration2));
            }
            else if (operCh == '/') {
                System.out.println(str + " = " + ration1.div(ration2));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Calc(str);
        sc.close();
    }
}
/*
1/3 + 2/5
1/3 - 2/5
1/3 * 2/5
1/3 / 2/5
*/