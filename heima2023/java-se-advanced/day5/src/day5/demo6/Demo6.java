package day5.demo6;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
public class Demo6 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(20, 30, 50, 10, 30, 20));
        for (Integer elem : set) {
            if (elem > 25) {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
    }
}