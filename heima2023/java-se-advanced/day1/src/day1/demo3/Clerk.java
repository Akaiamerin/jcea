package day1.demo3;
public class Clerk extends Employee {
    private Manager manager;
    public Clerk() {

    }
    public Clerk(String no, String name, String dept, Manager manager) {
        super(no, name, dept);
        this.manager = manager;
    }
    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    @Override
    public void output() {
        System.out.println(getDept() + "的" + getName() + "，编号 " + getNo() + "，上司是" + manager.getName() + "。");
    }
}