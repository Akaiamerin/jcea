package exp2;
import java.util.Scanner;
class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {

    }
    public IllegalTriangleException(String message) {
        super(message);
    }
}
class Triangle {
    private Double side1;
    private Double side2;
    private Double side3;
    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }
    public boolean isTriangle(Double side1, Double side2, Double side3) {
        if ((Double.compare(side1 + side2, side3) > 0) && (Double.compare(side1 + side3, side2) > 0) && (Double.compare(side2 + side3, side1) > 0)) {
            return true;
        }
        return false;
    }
    public Triangle(Double side1, Double side2, Double side3) throws IllegalTriangleException {
        if (isTriangle(side1, side2, side3) == false) {
            throw new IllegalTriangleException("在三角形中，任意两边之和总大于第三边");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Double getSide1() {
        return side1;
    }
    public Double getSide2() {
        return side2;
    }
    public Double getSide3() {
        return side3;
    }
    public Double getArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    public Double getCircumference() {
        return side1 + side2 + side3;
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        try {
            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println("面积：" + triangle.getArea());
            System.out.println("周长：" + triangle.getCircumference());
        }
        catch (IllegalTriangleException exc) {
            exc.printStackTrace();
        }
        sc.close();
    }
}