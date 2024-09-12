package exp1;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
public class Exp1 {
    public static double[][] plusArr(double[][] arr1, double[][] arr2) {
        Array2DRowRealMatrix mat1 = new Array2DRowRealMatrix(arr1);
        Array2DRowRealMatrix mat2 = new Array2DRowRealMatrix(arr2);
        double[][] result = mat1.add(mat2).getData();
        return result;
    }
    public static double[][] minusArr(double[][] arr1, double[][] arr2) {
        Array2DRowRealMatrix mat1 = new Array2DRowRealMatrix(arr1);
        Array2DRowRealMatrix mat2 = new Array2DRowRealMatrix(arr2);
        double[][] result = mat1.subtract(mat2).getData();
        return result;
    }
    public static double[][] mulArr(double[][] arr1, double[][] arr2) {
        Array2DRowRealMatrix mat1 = new Array2DRowRealMatrix(arr1);
        Array2DRowRealMatrix mat2 = new Array2DRowRealMatrix(arr2);
        double[][] result = mat1.multiply(mat2).getData();
        return result;
    }
    public static void outputArr(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        double[][] arr1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        double[][] arr2 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        double[][] plusArr = plusArr(arr1, arr2);
        outputArr(plusArr);
        System.out.println();
        double[][] minusArr = minusArr(arr1, arr2);
        outputArr(minusArr);
        System.out.println();
        double[][] mulArr = mulArr(arr1, arr2);
        outputArr(mulArr);
    }
}