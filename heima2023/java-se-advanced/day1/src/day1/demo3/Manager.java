package day1.demo3;
public class Manager extends Employee {
    private Clerk clerk;
    public Manager() {

    }
    public Manager(String no, String name, String dept, Clerk clerk) {
        super(no, name, dept);
        this.clerk = clerk;
    }
    public Clerk getClerk() {
        return clerk;
    }
    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void output() {
        System.out.println(getDept() + "的" + getName() + "，编号 " + getNo() + "，下属是" + clerk.getName() + "。");
    }
}