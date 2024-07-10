package exp3;
import java.util.Scanner;
public class Exp3 {
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
    public static int[][] plusMat(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }
    public static int[][] mulMat(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                for (int k = 0; k < mat1[i].length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
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
        int[][] mat2 = new int[row][col];
        inputMat(mat2, sc);
        int[][] plusMat = plusMat(mat1, mat2);
        outputMat(plusMat);
        System.out.println();
        int[][] mulMat = mulMat(mat1, mat2);
        outputMat(mulMat);
        sc.close();
    }
}