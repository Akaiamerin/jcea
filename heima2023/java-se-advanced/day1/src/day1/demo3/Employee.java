package day1.demo3;
public abstract class Employee {
    private String no;
    private String name;
    private String dept;
    public Employee() {

    }
    public Employee(String no, String name, String dept) {
        this.no = no;
        this.name = name;
        this.dept = dept;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public abstract void output();
}