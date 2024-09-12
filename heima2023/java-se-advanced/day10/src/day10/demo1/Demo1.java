package day10.demo1;
public class Demo1 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
            }
        }).start();
    }
}