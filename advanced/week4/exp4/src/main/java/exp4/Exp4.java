package exp4;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
class Fac1 implements Callable<BigInteger> {
    private int num;
    public Fac1(int num) {
        this.num = num;
    }
    @Override
    public BigInteger call() {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        return result;
    }
}
class FacSum1 implements Callable<BigInteger> {
    private ThreadPoolExecutor threadPoolExecutor;
    private List<Future<BigInteger>> list;
    public FacSum1() {
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.list = new ArrayList<>();
    }
    @Override
    public BigInteger call() {
        BigInteger result = BigInteger.valueOf(0);
        while (threadPoolExecutor.getCompletedTaskCount() < list.size()) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                Future<BigInteger> future = list.get(i);
                result = result.add(future.get());
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        return result;
    }
    public BigInteger facSum(int num) {
        if (num == 0) {
            return BigInteger.valueOf(1);
        }
        for (int i = 1; i <= num; i++) {
            Future<BigInteger> future = threadPoolExecutor.submit(new Fac1(i));
            list.add(future);
        }
        FutureTask<BigInteger> futureTask = new FutureTask<>(this);
        threadPoolExecutor.submit(futureTask);
        BigInteger result = BigInteger.valueOf(0);
        try {
            result = futureTask.get();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            threadPoolExecutor.shutdown();
        }
        return result;
    }
}
class FacSum2 {
    private List<BigInteger> list;
    public FacSum2() {
        this.list = new ArrayList<>();
    }
    private void fac(int num) {
        list.add(BigInteger.valueOf(1));
        for (int i = 1; i <= num; i++) {
            list.add(BigInteger.valueOf(i).multiply(list.get(i - 1)));
        }
    }
    public BigInteger facSum(int num) {
        if (num == 0) {
            return BigInteger.valueOf(1);
        }
        fac(num);
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 1; i <= num; i++) {
            result = result.add(list.get(i));
        }
        return result;
    }
}
public class Exp4 {
    public static void main(String[] args) {
        long begin1 = System.currentTimeMillis();
        System.out.println(new FacSum1().facSum(100));
        long end1 = System.currentTimeMillis();
        System.out.println("并行计算：" + (end1 - begin1) + " ms");
        long begin2 = System.currentTimeMillis();
        System.out.println(new FacSum2().facSum(100));
        long end2 = System.currentTimeMillis();
        System.out.println("顺序计算：" + (end2 - begin2) + " ms");
    }
}