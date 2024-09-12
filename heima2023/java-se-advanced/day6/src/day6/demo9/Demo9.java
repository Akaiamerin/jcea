package day6.demo9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Demo9 {
    public static void main(String[] args) {
        List<Map<Integer, Student>> list = new ArrayList<>();
        Map<Integer, Student> class1 = new HashMap<>(
                Map.ofEntries(
                        Map.entry(111, new Student(111, "张三", "男")),
                        Map.entry(222, new Student(222, "李四", "男")),
                        Map.entry(333, new Student(333, "王五", "男"))
                )
        );
        list.add(class1);
        Map<Integer, Student> class2 = new HashMap<>(
                Map.ofEntries(
                        Map.entry(444, new Student(444, "赵六", "女")),
                        Map.entry(555, new Student(555, "钱七", "女"))
                )
        );
        list.add(class2);
        for (Map<Integer, Student> classNo : list) {
            for (Map.Entry<Integer, Student> student : classNo.entrySet()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }
}