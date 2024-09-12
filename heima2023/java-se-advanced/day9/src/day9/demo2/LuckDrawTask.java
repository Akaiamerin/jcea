package day9.demo2;
public class LuckDrawTask implements Runnable {
    private int num = 100;
    public LuckDrawTask() {

    }
    public void run() {
        int cnt = 0;
        String threadName = Thread.currentThread().getName();
        while (true) {
            synchronized (this) {
                if (num > 0) {
                    String ball = DoubleColorBall.create();
                    System.out.println(num + " 号员工从" + threadName + "入场！拿到的双色球彩票号码是 " + ball);
                    cnt++;
                    num--;
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
                else {
                    System.out.println("共有 " + cnt + " 位员工从" + threadName + "入场");
                    break;
                }
            }
        }
    }
}