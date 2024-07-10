package exp1;
import java.security.SecureRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Account {
    private Double principal;
    private Lock lock;
    private Condition depositCondition;
    private Condition withdrawCondition;
    public Account(Double principal) {
        this.principal = principal;
        lock = new ReentrantLock();
        depositCondition = lock.newCondition();
        withdrawCondition = lock.newCondition();
    }
    private void deposit(int money) {
        try {
            lock.lock();
            principal += money;
            System.out.println("存款金额：" + money + " 账户余额：" + principal + "元");
            withdrawCondition.signal();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    private void withdraw(int money) {
        try {
            lock.lock();
            while (money > principal) {
                System.out.println("取款金额：" + money + " 账户余额：" + principal + "，超出 " + (money - principal) + "元");
                withdrawCondition.await();
            }
            principal -= money;
            System.out.println("取款金额：" + money + " 账户余额：" + principal + "元");
            depositCondition.signal();
        }
        catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    private class DepositThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    deposit(new SecureRandom().nextInt(0, 100));
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
    private class WithdrawThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    withdraw(new SecureRandom().nextInt(0, 100));
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
    public void simulate() {
        new Thread(new DepositThread()).start();
        new Thread(new WithdrawThread()).start();
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Account account = new Account(100.0);
        account.simulate();
    }
}