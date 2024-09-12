package day5.demo4;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Demo4 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("刘备", "关羽", "张飞", "刘备", "张飞"));
        System.out.println(set.size());
        Iterator<String> iter = set.iterator();
        while (iter.hasNext() == true) {
            String name = iter.next();
            System.out.print(name + " ");
        }
        System.out.println();
        for (String name : set) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}