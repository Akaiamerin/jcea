package exp1;
import java.util.Scanner;
class InvalidRadiusException extends Exception {
    public InvalidRadiusException() {

    }
    public InvalidRadiusException(String str) {
        super(str);
    }
}
class Circle {
    private Double radius;
    public Circle() {

    }
    public Circle(Double radius) {
        this.radius = radius;
    }
    public void setRadius(Double radius) throws InvalidRadiusException {
        if (Double.compare(radius, 0) < 0) {
            throw new InvalidRadiusException("半径不能为负");
        }
        this.radius = radius;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle cir = new Circle();
        double radius = sc.nextDouble();
        try {
            cir.setRadius(radius);
        }
        catch (InvalidRadiusException exc) {
            exc.printStackTrace();
        }
        sc.close();
    }
}