package day2.demo2;
public class JavaTeacher extends Employee {
    public JavaTeacher() {

    }
    public JavaTeacher(String name) {
        super(name);
    }
    @Override
    public void work() {
        System.out.println(getName() + "老师上 Java 课");
    }
}