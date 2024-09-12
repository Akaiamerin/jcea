package day9.demo5;
public class GuessNumberTask implements Runnable {
    private NumberGame numberGame;
    public GuessNumberTask(NumberGame numberGame) {
        this.numberGame = numberGame;
    }
    @Override
    public void run() {
        if (numberGame.getGuessResult() == 101) {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        int guessNumber = 0;
        int min = 0;
        int max = 100;
        for (int i = 1; ; i++) {
            if (i == 1) {
                guessNumber = (min + max) / 2;
                numberGame.setGuessNumber(guessNumber);
                System.out.println("第 " + i + " 次猜：" + guessNumber);
            }
            else {
                if (numberGame.getGuessResult() == -1) {
                    min = guessNumber;
                    guessNumber = (min + max) / 2;
                    numberGame.setGuessNumber(guessNumber);
                    System.out.println("第 " + i + " 次猜：" + guessNumber);
                }
                else if (numberGame.getGuessResult() == 1) {
                    max = guessNumber;
                    guessNumber = (min + max) / 2;
                    numberGame.setGuessNumber(guessNumber);
                    System.out.println("第 " + i + " 次猜：" + guessNumber);
                }
                else {
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