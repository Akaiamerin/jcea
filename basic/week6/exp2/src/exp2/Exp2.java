package exp2;
import java.util.Scanner;
class QuadraticEquation {
    private Double a;
    private Double b;
    private Double c;
    QuadraticEquation() {

    }
    QuadraticEquation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Double getA() {
        return a;
    }
    public Double getB() {
        return b;
    }
    public Double getC() {
        return c;
    }
    public void setA(Double a) {
        this.a = a;
    }
    public void setB(Double b) {
        this.b = b;
    }
    public void setC(Double c) {
        this.c = c;
    }
    public Double getDiscriminant() {
        return (b * b - 4 * a * c);
    }
    public Double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant())) / 2 * a;
    }
    public Double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant())) / 2 * a;
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 a b c：");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("x1 = " + quadraticEquation.getRoot1() + " " + "x2 = " + quadraticEquation.getRoot2());
        }
        else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("x = " + quadraticEquation.getRoot1());
        }
        else {
            System.out.println("The equation has no roots.");
        }
        sc.close();
    }
}