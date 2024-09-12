package day6.demo7;
import java.util.LinkedHashMap;
import java.util.Map;
public class Demo7 {
    public static void main(String[] args) {
        Map<Student, String> map = new LinkedHashMap<>(
                Map.ofEntries(
                        Map.entry(new Student(1, "张三", "男"), "北京"),
                        Map.entry(new Student(2, "李四", "男"), "上海")
                )
        );
        System.out.println(map);
    }
}