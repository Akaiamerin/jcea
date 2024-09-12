package day6;
import java.util.Scanner;
public class Demo1 {
    public static void outputMat(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入行：");
        int row = sc.nextInt();
        System.out.print("请输入列：");
        int col = sc.nextInt();
        outputMat(row, col);
        sc.close();
    }
}