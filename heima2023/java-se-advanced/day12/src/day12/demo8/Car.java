package day12.demo8;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Car {
    private static int count = 3;
    private static List<Car> carList = new ArrayList<>();
    static {
        for (int i = 0; i < count; i++) {
            carList.add(new Car());
        }
    }
    private Car() {

    }
    public static Car getInstance() {
        int index = new Random().nextInt(0, count);
        return carList.get(index);
    }
}