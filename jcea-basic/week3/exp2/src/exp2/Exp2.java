package exp2;
import java.util.Scanner;
public class Exp2 {
    public static void inputMat(int[][] mat, Scanner sc) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
    public static void outputMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] transposeMat(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = mat[j][i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 3;
        int col = 3;
        int[][] mat1 = new int[row][col];
        inputMat(mat1, sc);
        int[][] mat2 = transposeMat(mat1);
        outputMat(mat2);
        sc.close();
    }
}