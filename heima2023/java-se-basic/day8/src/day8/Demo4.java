package day8;
public class Demo4 {
    public static void main(String[] args) {
        int[][] arr = {
                {11, 22, 33},
                {44, 55, 66},
                {77, 88, 99},
                {11, 22, 33}
        };
        int sum1 = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum1 += arr[0][i];
        }
        System.out.println("一季度：" + sum1 + " 万元");
        int sum2 = 0;
        for (int i = 0; i < arr[1].length; i++) {
            sum2 += arr[1][i];
        }
        System.out.println("二季度：" + sum2 + " 万元");
        int sum3 = 0;
        for (int i = 0; i < arr[2].length; i++) {
            sum3 += arr[2][i];
        }
        System.out.println("三季度：" + sum3 + " 万元");
        int sum4 = 0;
        for (int i = 0; i < arr[3].length; i++) {
            sum4 += arr[3][i];
        }
        System.out.println("四季度：" + sum4 + " 万元");
    }
}