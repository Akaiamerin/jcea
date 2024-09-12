package day5.demo2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class Demo2 {
    public static int getIndex(List<Integer> list, Integer target) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), target) == true) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(getIndex(list, 1));
    }
}