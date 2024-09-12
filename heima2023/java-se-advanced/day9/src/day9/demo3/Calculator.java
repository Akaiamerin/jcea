package day9.demo3;
import java.util.concurrent.Callable;
public class Calculator implements Callable<Integer> {
    public Calculator() {

    }
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}