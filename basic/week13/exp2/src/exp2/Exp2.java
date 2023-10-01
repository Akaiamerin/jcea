package exp2;
import java.util.Arrays;
class Garage {
    private final boolean[] parkingArr = {true, true, true};
    public Garage() {

    }
    private boolean state(boolean bool) {
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
        if (carNum == 3) {
            return true;
        }
        return false;
    }
    public synchronized void enter() {
        if (state(false) == true) {
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
        if (state(true) == true) {
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
    private class carEnter implements Runnable {
        private Garage garage;
        public carEnter() {
        }
        public carEnter(Garage garage) {
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
    private class carLeave implements Runnable {
        private Garage garage;
        public carLeave() {
        }
        public carLeave(Garage garage) {
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
        Garage garage = new Garage();
        Thread car1 = new Thread(new Thread(new carEnter(garage)), "car1");
        Thread car2 = new Thread(new Thread(new carEnter(garage)), "car2");
        Thread car3 = new Thread(new Thread(new carEnter(garage)), "car3");
        Thread drv = new Thread(new Thread(new carLeave(garage)), "drv");
        car1.start();
        car3.start();
        car2.start();
        drv.start();
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.simulate();
    }
}