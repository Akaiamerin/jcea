package exp1;
import java.util.Scanner;
class InvalidRadiusException extends Exception {
    public InvalidRadiusException() {

    }
    public InvalidRadiusException(String message) {
        super(message);
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
        double radius = sc.nextDouble();
        Circle circle = new Circle();
        try {
            circle.setRadius(radius);
        }
        catch (InvalidRadiusException exc) {
            exc.printStackTrace();
        }
        sc.close();
    }
}