package day10.demo2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("cab", "bac", "acb", "cba", "bca", "abc"));
        Collections.sort(list, (String elem1, String elem2)->{
            return Objects.compare(elem2, elem1, Comparator.comparing(String::valueOf));
        });
        System.out.println(list);
    }
}