package day9.demo5;
public class Demo5 {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        RandomNumberTask randomNumberTask = new RandomNumberTask(numberGame);
        GuessNumberTask guessNumberTask = new GuessNumberTask(numberGame);
        new Thread(randomNumberTask, randomNumberTask.getClass().getName()).start();
        new Thread(guessNumberTask, guessNumberTask.getClass().getName()).start();
    }
}