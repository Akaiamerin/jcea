package day5.demo5;
import java.util.HashSet;
import java.util.Set;
public class Demo5 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("张三", "男", 20));
        set.add(new Student("李四", "男", 21));
        set.add(new Student("张三", "男", 20));
        for (Student student : set) {
            System.out.println(student.getName() + " " + student.getGender() + " " + student.getAge());
        }
    }
}