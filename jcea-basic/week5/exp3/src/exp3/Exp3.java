package exp3;
interface Shape {
    double getArea();
}
class Rectangle implements Shape {
    private Double length;
    private Double width;
    public Rectangle() {

    }
    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }
    public Double getArea() {
        return length * width;
    }
}
class Circle implements Shape {
    private Double radius;
    public Circle() {

    }
    public Circle(Double radius) {
        this.radius = radius;
    }
    public Double getArea() {
        return Math.PI * radius;
    }
}
public class Exp3 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        System.out.println(rectangle.getArea());
        Circle circle = new Circle(10.0);
        System.out.println(circle.getArea());
    }
}