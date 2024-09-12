package day8;
import java.util.Random;
public class Demo3 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int evenCnt = 0;
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(0, 101);
            if (arr1[i] % 2 == 0) {
                evenCnt++;
            }
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        int[] arr2 = new int[evenCnt];
        int arr2Index = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 == 0) {
                arr2[arr2Index] = arr1[i];
                System.out.print(arr2[arr2Index] + " ");
                arr2Index++;
            }
        }
        System.out.println();
    }
}