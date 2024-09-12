package day4.demo6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
public class Demo6 {
    public static void main(String[] args) {
        Collection<Number> collection = new ArrayList<>(Arrays.asList(88.5, 39.2, 77.1, 56.8, 89, 99, 59.5));
        for (Number num : collection) {
            System.out.print(num + " ");
        }
        System.out.println();
        int failCnt = 0;
        double sum = 0.0;
        double maxScore = Double.MIN_VALUE;
        for (Number num : collection) {
            double score = num.doubleValue();
            if (score < 60) {
                failCnt++;
            }
            sum += score;
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(failCnt + " " + sum / collection.size() + " " + maxScore);
    }
}