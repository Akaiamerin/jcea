package day5.demo1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext() == true) {
            Integer elem = iter.next();
            System.out.print(elem + " ");
        }
        System.out.println();
        for (Integer elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}