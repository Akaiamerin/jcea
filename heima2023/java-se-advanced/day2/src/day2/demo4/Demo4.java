package day2.demo4;
public class Demo4 {
    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.charge();
        Taxi taxi = new Taxi();
        taxi.charge();
        Cinema cinema = new Cinema();
        cinema.charge();
        cinema.play();
    }
}