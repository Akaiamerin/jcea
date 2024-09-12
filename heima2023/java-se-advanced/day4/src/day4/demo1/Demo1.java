package day4.demo1;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Demo1 {
    public static void main(String[] args) {
        double[] arr = {0.1, 0.2, 2.1, 3.2, 5.56, 7.21};
        BigDecimal sum = BigDecimal.valueOf(0.0);
        for (int i = 0; i < arr.length; i++) {
            sum = sum.add(BigDecimal.valueOf(arr[i]));
        }
        BigDecimal avg = sum.divide(BigDecimal.valueOf(arr.length), RoundingMode.HALF_UP);
        System.out.println(sum + " " + avg);
    }
}