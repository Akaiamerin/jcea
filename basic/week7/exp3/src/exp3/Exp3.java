package exp3;
import java.util.Scanner;
class BinaryFormatException extends Exception {
    public BinaryFormatException() {

    }
    public BinaryFormatException(String message) {
        super(message);
    }
}
public class Exp3 {
    public static int binToDec(String binStr) throws BinaryFormatException {
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) < '0' || binStr.charAt(i) > '1') {
                throw new BinaryFormatException("0 or 1");
            }
        }
        int result = 0;
        int binNum = Integer.parseInt(binStr);
        int power = 0;
        while (binNum > 0) {
            int temp = binNum % 10;
            result += temp * Math.pow(2, power++);
            binNum /= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binStr = sc.next();
        try {
            System.out.println(binToDec(binStr));
        }
        catch (BinaryFormatException exc) {
            exc.printStackTrace();
        }
        sc.close();
    }
}