package day6.demo3;
import java.util.Arrays;
public class Demo3 {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElemIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElemIndex]) {
                    minElemIndex = j;
                }
            }
            if (minElemIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElemIndex];
                arr[minElemIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 432, 32, 54, 32, 3, 7, 657, 563, 25, 43, 6, 463, 52};
        System.out.println(Arrays.toString(arr));
        // bubbleSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}