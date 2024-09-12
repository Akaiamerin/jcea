package day8.demo3;
public class Demo3 {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.setName("张三");
            student.setGender('男');
            student.setAge(100);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}