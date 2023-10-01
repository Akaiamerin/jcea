package exp2;
public class Exp2 {
    private static int greatestCommonDivisor(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        return greatestCommonDivisor(n2, n1 % n2);
    }
    public static int leastCommonMultiple(int n1, int n2) {
        return n1 * n2 / greatestCommonDivisor(n1, n2);
    }
}