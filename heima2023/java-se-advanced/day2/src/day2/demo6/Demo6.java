package day2.demo6;
public class Demo6 {
    public static void main(String[] args) {
        Student student = new Student("张三", Gender.BOY, 20);
        System.out.println(student.getName() + " " + student.getGender().getDescription() + " " + student.getAge());
    }
}