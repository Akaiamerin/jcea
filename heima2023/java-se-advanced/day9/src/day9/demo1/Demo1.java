package day9.demo1;
public class Demo1 {
    public static void main(String[] args) {
        // TicketTask1 task1 = new TicketTask1();
        // new Thread(task1, "窗口 1").start();
        // new Thread(task1, "窗口 2").start();
        // new Thread(task1, "窗口 3").start();
        // TicketTask2 task2 = new TicketTask2();
        // new Thread(task2, "窗口 1").start();
        // new Thread(task2, "窗口 2").start();
        // new Thread(task2, "窗口 3").start();
        TicketTask3 task3 = new TicketTask3();
        new Thread(task3, "窗口 1").start();
        new Thread(task3, "窗口 2").start();
        new Thread(task3, "窗口 3").start();
    }
}