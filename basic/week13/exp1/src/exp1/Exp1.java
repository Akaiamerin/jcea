package exp1;
class Pool {
    private volatile int cap = 100;
    private static int cnt = 0;
    public Pool() {

    }
    private synchronized boolean drainage(int discharge) {
        if (cap == 0) {
            return false;
        }
        cap -= discharge;
        cap = Math.max(cap, 0);
        cnt++;
        System.out.println("[" + Thread.currentThread().getName() + ", " + cap + "L] ");
        return true;
    }
    private class Outfall implements Runnable {
        String no;
        int discharge;
        public Outfall(String no, int discharge) {
            this.no = no;
            this.discharge = discharge;
        }
        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    if (drainage(discharge) == false) {
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    }
                    catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + cnt + "s");
        }
    }
    public void simulate() {
        new Thread(new Outfall("A", 1), "A").start();
        new Thread(new Outfall("B", 2), "B").start();
        new Thread(new Outfall("C", 3), "C").start();
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.simulate();
    }
}