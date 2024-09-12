package day9.demo4;
public class Demo4 {
    public synchronized static void printNumber(int num) {
        try {
            Demo4.class.notify();
            System.out.println(Thread.currentThread().getName() + "：" + num);
            Demo4.class.wait();
        }
        catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Thread(
                ()->{
                    for (int i = 1; i <= 100; i += 2) {
                        printNumber(i);
                    }
                },
                "奇数"
        )
                .start();
        new Thread(
                ()->{
                    for (int i = 2; i <= 100; i += 2) {
                        printNumber(i);
                    }
                },
                "偶数"
        )
                .start();
    }
}