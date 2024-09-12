package day6.demo1;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class Demo1 {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> set1 = new TreeSet<>();
        while (set1.size() < 10) {
            set1.add(random.nextInt(0, 51));
        }
        System.out.println(set1);
        Set<Integer> set2 = new TreeSet<>((elem1, elem2)->{
            return elem2 - elem1;
        });
        while (set2.size() < 10) {
            set2.add(random.nextInt(50, 101));
        }
        System.out.println(set2);
    }
}