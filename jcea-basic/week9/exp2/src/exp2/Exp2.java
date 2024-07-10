package exp2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Exp2 {
    public static void inputNum(Map<Integer, Integer> numMap, Scanner sc) {
        while (true) {
            System.out.print("Enter an integer: ");
            Integer num = sc.nextInt();
            if (num == 0) {
                break;
            }
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
    }
    public static Integer getMaxCntNum(Map<Integer, Integer> numMap) {
        Integer maxCnt = 0;
        Integer maxCntNum = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                maxCntNum = entry.getKey();
            }
        }
        return maxCntNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> numMap = new HashMap<>();
        inputNum(numMap, sc);
        Integer maxCntNum = getMaxCntNum(numMap);
        System.out.println("Number " + maxCntNum + " occurred most");
        sc.close();
    }
}