package day8;
import java.util.Random;
import java.util.Scanner;
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 101);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println(num + " 不存在");
        }
        else {
            System.out.println(num + " 在数组中的索引为 " + index);
        }
        sc.close();
    }
}