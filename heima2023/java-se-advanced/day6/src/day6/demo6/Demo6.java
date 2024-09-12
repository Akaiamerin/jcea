package day6.demo6;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class Demo6 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(
                Map.ofEntries(
                        Map.entry("张三", 2100),
                        Map.entry("李四", 1700),
                        Map.entry("王五", 1800),
                        Map.entry("赵六", 2600),
                        Map.entry("孙七", 3800)
                )
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (Objects.equals(entry.getKey(), "张三") == true) {
                map.put(entry.getKey(), entry.getValue() + 300);
            }
        }
        System.out.println(map);
    }
}