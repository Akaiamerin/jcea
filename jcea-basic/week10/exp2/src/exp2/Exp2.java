package exp2;
import java.util.ArrayList;
import java.util.List;
interface PrimeNumInterface {
    List<Integer> getPrimeNums(int maxNum);
}
public class Exp2 {
    public static void main(String[] args) {
        PrimeNumInterface PrimeNums = ((int maxNum)->{
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i <= maxNum; i++) {
                boolean flag = true;
                if (i == 2) {
                    flag = true;
                }
                else {
                    for (int j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag == true) {
                    list.add(i);
                }
            }
            return list;
        });
        List<Integer> list = PrimeNums.getPrimeNums(100);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}