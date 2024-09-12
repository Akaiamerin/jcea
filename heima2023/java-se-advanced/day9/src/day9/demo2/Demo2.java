package day9.demo2;
public class Demo2 {
    public static void main(String[] args) {
        LuckDrawTask task = new LuckDrawTask();
        new Thread(task, "前门").start();
        new Thread(task, "后门").start();
    }
}