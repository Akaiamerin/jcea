package day8;
import java.util.Random;
public class Demo2 {
    public static int getMax(int[] arr) {
        int maxElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElem = Math.max(maxElem, arr[i]);
        }
        return maxElem;
    }
    public static double getAvg(int[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 101);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(getMax(arr));
        System.out.println(getAvg(arr));
    }
}