package day6;
import java.util.Scanner;
public class Demo2 {
    public static int[] getArr(int len) {
        int[] arr = new int[len];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个元素：");
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = getArr(5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}