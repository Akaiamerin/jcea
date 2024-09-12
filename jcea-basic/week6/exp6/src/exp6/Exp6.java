package exp6;
import java.util.Scanner;
class Complex {
    private Double a;
    private Double b;
    public Complex() {
        this.a = 0.0;
        this.b = 0.0;
    }
    public Complex(Double a) {
        this.a = a;
        this.b = 0.0;
    }
    public Complex(Double a, Double b) {
        this.a = a;
        this.b = b;
    }
    public Double getA() {
        return a;
    }
    public void setA(Double a) {
        this.a = a;
    }
    public Double getB() {
        return b;
    }
    public void setB(Double b) {
        this.b = b;
    }
    @Override
    public String toString() {
        if (Double.compare(a, 0.0) == 0 && Double.compare(b, 0.0) == 0) {
            return "0";
        }
        else if (Double.compare(a, 0.0) == 0 && Double.compare(b, 0.0) != 0) {
            return b + "i";
        }
        else if (Double.compare(a, 0.0) != 0 && Double.compare(b, 0.0) == 0) {
            return String.valueOf(a);
        }
        else if (Double.compare(a, 0.0) != 0 && Double.compare(b, 0.0) < 0) {
            return a + " - " + Math.abs(b) + "i";
        }
        return a + " + " + b + "i";
    }
    public Double getRealPart() {
        return getA();
    }
    public Double getImaginaryPart() {
        return getB();
    }
}
interface Calculation {
    Complex plus();
    Complex minus();
    Complex mul();
    Complex div();
    Double abs(int no);
}
class ComplexCalculation implements Calculation {
    private Complex complex1;
    private Complex complex2;
    public ComplexCalculation() {

    }
    public ComplexCalculation(Complex complex1, Complex complex2) {
        this.complex1 = complex1;
        this.complex2 = complex2;
    }
    public Complex plus() {
        Complex result = new Complex(complex1.getRealPart() + complex2.getRealPart(), complex1.getImaginaryPart() + complex2.getImaginaryPart());
        return result;
    }
    public Complex minus() {
        Complex result = new Complex(complex1.getRealPart() - complex2.getRealPart(), complex1.getImaginaryPart() - complex2.getImaginaryPart());
        return result;
    }
    public Complex mul() {
        Complex result = new Complex(complex1.getRealPart() * complex2.getRealPart() - complex1.getImaginaryPart() * complex2.getImaginaryPart(), complex1.getImaginaryPart() * complex2.getRealPart() + complex1.getRealPart() * complex2.getImaginaryPart());
        return result;
    }
    public Complex div() {
        Complex result = new Complex((complex1.getRealPart() * complex2.getRealPart() + complex1.getImaginaryPart() * complex2.getImaginaryPart()) / (complex2.getRealPart() * complex2.getRealPart() + complex2.getImaginaryPart() * complex2.getImaginaryPart()), (complex1.getImaginaryPart() * complex2.getRealPart() - complex1.getRealPart() * complex2.getImaginaryPart()) / (complex2.getRealPart() * complex2.getRealPart() + complex2.getImaginaryPart() * complex2.getImaginaryPart()));
        return result;
    }
    public Double abs(int no) {
        Double result = 0.0;
        if (no == 1) {
            result = Math.sqrt(complex1.getRealPart() * complex1.getRealPart() + complex1.getImaginaryPart() * complex1.getImaginaryPart());
        }
        else if (no == 2) {
            result = Math.sqrt(complex2.getRealPart() * complex2.getRealPart() + complex2.getImaginaryPart() * complex2.getImaginaryPart());
        }
        return result;
    }
}
public class Exp6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        System.out.print("Enter the second complex number: ");
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        Complex complex1 = new Complex(a1, b1);
        Complex complex2 = new Complex(a2, b2);
        ComplexCalculation complexCalc = new ComplexCalculation(complex1, complex2);
        System.out.println("(" + complex1 + ") + (" + complex2 + ") = " + complexCalc.plus());
        System.out.println("(" + complex1 + ") - (" + complex2 + ") = " + complexCalc.minus());
        System.out.println("(" + complex1 + ") * (" + complex2 + ") = " + complexCalc.mul());
        System.out.println("(" + complex1 + ") / (" + complex2 + ") = " + complexCalc.div());
        System.out.println("|" + complex1 + "| = " + complexCalc.abs(1));
        System.out.println("|" + complex2 + "| = " + complexCalc.abs(2));
        sc.close();
    }
}