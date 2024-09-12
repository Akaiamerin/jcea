package exp2;
abstract class Transport {
    public Transport() {

    }
    abstract void move();
}
class Train extends Transport {
    public Train() {

    }
    public void move() {
        System.out.println("火车在铁轨上行驶");
    }
}
class Car extends Transport {
    public Car() {

    }
    public void move() {
        System.out.println("汽车在公路上行驶");
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Train train = new Train();
        train.move();
        Car car = new Car();
        car.move();
    }
}