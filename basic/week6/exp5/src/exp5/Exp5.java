package exp5;
abstract class Shape {
    abstract Double getCircumference();
    abstract Double getArea();
}
class Circle extends Shape {
    private static final Double PI = Math.PI;
    private Double radius;
    public Circle() {

    }
    public Circle(Double radius) {
        this.radius = radius;
    }
    public Double getCircumference() {
        return 2 * Circle.PI * radius;
    }
    public Double getArea() {
        return Circle.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    private Double length;
    private Double width;
    public Rectangle() {

    }
    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }
    public Double getCircumference() {
        return 2 * (length + width);
    }
    public Double getArea() {
        return length * width;
    }
}
class ShapeCalculate {
    private ShapeCalculate() {

    }
    public static void calc(Shape shape) {
        System.out.println(shape.getCircumference());
        System.out.println(shape.getArea());
    }
}
public class Exp5 {
    public static void main(String[] args) {
        ShapeCalculate.calc(new Circle(10.0));
        ShapeCalculate.calc(new Rectangle(3.0, 4.0));
    }
}