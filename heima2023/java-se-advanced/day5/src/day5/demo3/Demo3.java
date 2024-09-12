package day5.demo3;
import java.util.ArrayList;
import java.util.List;
public class Demo3 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", "男", 20));
        list.add(new Student("李四", "男", 21));
        list.add(new Student("王五", "男", 22));
        Integer maxAge = list.get(0).getAge();
        int maxAgeIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getName() + " " + student.getGender() + " " + student.getAge());
            if (list.get(i).getAge() > maxAge) {
                maxAgeIndex = i;
            }
        }
        System.out.println();
        list.get(maxAgeIndex).setName("小猪佩奇");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getName() + " " + student.getGender() + " " + student.getAge());
        }
    }
}