package exp1;
public class Exp1 {
    public static int fac(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
    public static int facSum(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fac(n) + facSum(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(facSum(10));
    }
}