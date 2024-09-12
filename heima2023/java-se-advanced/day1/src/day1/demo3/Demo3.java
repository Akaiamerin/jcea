package day1.demo3;
public class Demo3 {
    public static void main(String[] args) {
        Manager manager = new Manager("M001", "张三", "销售部", null);
        Clerk clerk = new Clerk("C001", "李四", "销售部", null);
        manager.setClerk(clerk);
        clerk.setManager(manager);
        manager.output();
        clerk.output();
    }
}