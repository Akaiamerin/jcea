package day9.demo5;
public class NumberGame {
    private int randomNumber;
    private int guessNumber;
    private int guessResult = 101;
    public NumberGame() {

    }
    public int getRandomNumber() {
        return randomNumber;
    }
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
    public int getGuessNumber() {
        return guessNumber;
    }
    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }
    public int getGuessResult() {
        return guessResult;
    }
    public void setGuessResult(int guessResult) {
        this.guessResult = guessResult;
    }
}