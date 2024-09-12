package day2.demo2;
public class UITeacher extends Employee implements Paint {
    public UITeacher() {

    }
    public UITeacher(String name) {
        super(name);
    }
    @Override
    public void work() {
        System.out.println(getName() + "老师上 UI 课");
    }
    @Override
    public void paint() {
        System.out.println(getName() + "老师具备绘画技术");
    }
}