package day9.demo3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Demo3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1, Executors.defaultThreadFactory());
        Future<Integer> future = threadPool.submit(new Calculator());
        Integer sum = null;
        try {
            sum = future.get();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println(sum);
    }
}