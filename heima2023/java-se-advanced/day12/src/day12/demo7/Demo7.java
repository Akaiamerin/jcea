package day12.demo7;
public class Demo8 {
    public static void main(String[] args) {
        System.out.println(King1.getInstance() == King1.getInstance());
        System.out.println(King2.getInstance() == King2.getInstance());
    }
}