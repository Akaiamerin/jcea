package day6.demo4;
import java.util.HashMap;
import java.util.Map;
public class Demo4 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(
                Map.ofEntries(
                        Map.entry(1, "张三"),
                        Map.entry(2, "李四"),
                        Map.entry(3, "王五")
                )
        );
        System.out.println(map.size());
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(map.containsKey(2));
        map.remove(1);
        System.out.println(map);
    }
}