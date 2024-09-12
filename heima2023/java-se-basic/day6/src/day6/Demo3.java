package day6;
import java.util.Random;
public class Demo3 {
    public static int[] getArr(int len, int minElem, int maxElem) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(minElem, maxElem + 1);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = getArr(5, 1, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}