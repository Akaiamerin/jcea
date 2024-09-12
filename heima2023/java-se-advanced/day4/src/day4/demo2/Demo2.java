package day4.demo2;
import java.util.Arrays;
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {1, 332, 43, 25, 3324, 34, 335, 4, 45, 2, 43, 52, 54};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}