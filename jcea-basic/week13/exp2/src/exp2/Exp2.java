package exp2;
import java.util.Arrays;
class Garage {
    private boolean[] parkingArr;
    public Garage() {
        parkingArr = new boolean[]{true, true, true};
    }
    private boolean status(boolean bool) {
        int carNum = 0;
        for (int i = 0; i < parkingArr.length; i++) {
            if (bool == true) {
                if (parkingArr[i] == true) {
                    carNum++;
                }
            }
            else {
                if (parkingArr[i] == false) {
                    carNum++;
                }
            }
        }
        return carNum == parkingArr.length;
    }
    public synchronized void enter() {
        if (status(false) == true) {
            try {
                System.out.println("车位全满：[       ] 车库状态：" + Arrays.toString(parkingArr));
                wait();
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        else {
            int enterIndex = 0;
            for (int i = 0; i < parkingArr.length; i++) {
                if (parkingArr[i] == true) {
                    enterIndex = i;
                }
            }
            parkingArr[enterIndex] = false;
            System.out.println("有车进入：[" + Thread.currentThread().getName() + "->" + enterIndex + "] 车库状态：" + Arrays.toString(parkingArr));
            notifyAll();
        }
    }
    public synchronized void leave() {
        if (status(true) == true) {
            try {
                System.out.println("车位全空：[       ] 车库状态：" + Arrays.toString(parkingArr));
                wait();
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        int leaveIndex = 0;
        for (int i = 0; i < parkingArr.length; i++) {
            if (parkingArr[i] == false) {
                leaveIndex = i;
            }
        }
        parkingArr[leaveIndex] = true;
        System.out.println("有车离开：[" + leaveIndex + "->" + Thread.currentThread().getName() + " ] 车库状态：" + Arrays.toString(parkingArr));
        notifyAll();
    }
    private class CarEnter implements Runnable {
        private Garage garage;
        public CarEnter(Garage garage) {
            this.garage = garage;
        }
        @Override
        public void run() {
            while (true) {
                garage.enter();
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    private class CarLeave implements Runnable {
        private Garage garage;
        public CarLeave(Garage garage) {
            this.garage = garage;
        }
        @Override
        public void run() {
            while (true) {
                garage.leave();
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    public void simulate() {
        new Thread(new Thread(new CarEnter(this)), "car1").start();
        new Thread(new Thread(new CarEnter(this)), "car2").start();
        new Thread(new Thread(new CarEnter(this)), "car3").start();
        new Thread(new Thread(new CarLeave(this)), "drv").start();
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.simulate();
    }
}