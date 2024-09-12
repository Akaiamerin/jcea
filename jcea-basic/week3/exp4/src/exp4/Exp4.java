package exp4;
import java.util.Scanner;
public class Exp4 {
    public static void inputScore(double[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length + i; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
    }
    public static void getTotalScore(double[][] arr) {
        double minScore = arr[0][0];
        double maxScore = arr[0][0];
        double avgScore = 0.0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length + i; j++) {
                minScore = Math.min(arr[i][j], minScore);
                maxScore = Math.max(arr[i][j], maxScore);
                avgScore += arr[i][j];
            }
        }
        System.out.println("年级最高分：" + maxScore + " 年级最低分：" + minScore + " 年级平均分：" + (avgScore / (3 + 4 + 5)));
    }
    public static void getOneScore(double[][] arr, int classNo) {
        double minScore = arr[classNo - 1][0];
        double maxScore = arr[classNo - 1][0];
        double avgScore = 0.0;
        for (int i = 0; i < classNo + 2; i++) {
            minScore = Math.min(arr[classNo - 1][i], minScore);
            maxScore = Math.max(arr[classNo - 1][i], maxScore);
            avgScore += arr[classNo - 1][i];
        }
        System.out.println(classNo + "班：最高分：" + maxScore + " 最低分：" + minScore + " 平均分：" + (avgScore / (classNo + 2)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 3;
        int col = 5;
        double[][] classArr = new double[row][col];
        inputScore(classArr, sc);
        getTotalScore(classArr);
        getOneScore(classArr, 1);
        getOneScore(classArr, 2);
        getOneScore(classArr, 3);
        sc.close();
    }
}