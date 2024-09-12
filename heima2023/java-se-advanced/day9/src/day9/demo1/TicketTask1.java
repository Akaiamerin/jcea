package day9.demo1;
public class TicketTask1 implements Runnable {
    private int num = 100;
    public TicketTask1() {

    }
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
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
        }
    }
}