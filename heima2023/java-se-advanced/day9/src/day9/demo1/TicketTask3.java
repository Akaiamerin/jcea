package day9.demo1;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class TicketTask3 implements Runnable {
    private int num = 100;
    private final Lock lock = new ReentrantLock();
    public TicketTask3() {

    }
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (num <= 0) {
                    break;
                }
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：" + num);
                num--;
            }
            finally {
                lock.unlock();
            }
        }
    }
}