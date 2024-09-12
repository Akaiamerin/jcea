package day2.demo3;
public class Circle implements Shape {
    public static final double PI = 3.14;
    private double radius;
    private double x;
    private double y;
    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
        this.x = 0;
        this.y = 0;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setCenter(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public double getArea() {
        return Circle.PI * radius * radius;
    }
    @Override
    public double getCircumference() {
        return 2 * Circle.PI * radius;
    }
}