package day9.demo1;
public class TicketTask2 implements Runnable {
    private int num = 100;
    public TicketTask2() {

    }
    public synchronized void sellTicket() {
        if (num <= 0) {
            return;
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
    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            sellTicket();
        }
    }
}