package day9.demo5;
import java.util.Random;
public class RandomNumberTask implements Runnable {
    private NumberGame numberGame;
    public RandomNumberTask(NumberGame numberGame) {
        this.numberGame = numberGame;
    }
    @Override
    public void run() {
        for (int i = 1; ; i++) {
            if (i == 1) {
                int randomNumber = new Random().nextInt(1, 101);
                numberGame.setRandomNumber(randomNumber);
            }
            else {
                if (numberGame.getGuessNumber() < numberGame.getRandomNumber()) {
                    numberGame.setGuessResult(-1);
                    System.out.println(numberGame.getGuessNumber() + " 猜小了");
                }
                else if (numberGame.getGuessNumber() > numberGame.getRandomNumber()) {
                    numberGame.setGuessResult(1);
                    System.out.println(numberGame.getGuessNumber() + " 猜大了");
                }
                else {
                    numberGame.setGuessResult(0);
                    System.out.println(numberGame.getGuessNumber() + " 猜对了");
                    break;
                }
            }
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}