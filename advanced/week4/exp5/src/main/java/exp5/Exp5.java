package exp5;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
class PlusRandMat1 extends RecursiveAction {
    private static final int THRESHOLD = 100;
    private RandMat1 randMat11;
    private RandMat1 randMat12;
    private RandMat1 ret;
    private int left;
    private int right;
    public PlusRandMat1(RandMat1 randMat11, RandMat1 randMat12, RandMat1 ret, int left, int right) {
        this.randMat11 = randMat11;
        this.randMat12 = randMat12;
        this.ret = ret;
        this.left = left;
        this.right = right;
    }
    @Override
    protected void compute() {
        if (right - left < THRESHOLD) {
            for (int i = left; i < randMat11.mat.length; i++) {
                for (int j = left; j < right; j++) {
                    ret.mat[i][j] = randMat11.mat[i][j] + randMat12.mat[i][j];
                }
            }
        }
        else {
            int mid = left + (right - left) / 2;
            invokeAll(new PlusRandMat1(randMat11, randMat12, ret, left, mid), new PlusRandMat1(randMat11, randMat12, ret, mid, right));
        }
    }
}
class MulRandMat1OneRow extends RecursiveAction {
    private RandMat1 randMat11;
    private RandMat1 randMat12;
    private RandMat1 ret;
    int row;
    int col;
    public MulRandMat1OneRow(RandMat1 randMat11, RandMat1 randMat12, RandMat1 ret, int row, int col) {
        this.randMat11 = randMat11;
        this.randMat12 = randMat12;
        this.ret = ret;
        this.row = row;
        this.col = col;
    }
    @Override
    public void compute() {
        for (int i = 0; i < randMat11.mat[row].length; i++) {
            ret.mat[row][col] += randMat11.mat[row][i] * randMat12.mat[i][col];
        }
    }
}
class MulRandMat1 extends RecursiveAction {
    private RandMat1 randMat11;
    private RandMat1 randMat12;
    private RandMat1 ret;
    public MulRandMat1(RandMat1 randMat11, RandMat1 randMat12, RandMat1 ret) {
        this.randMat11 = randMat11;
        this.randMat12 = randMat12;
        this.ret = ret;
    }
    @Override
    protected void compute() {
        List<RecursiveAction> list = new ArrayList<>();
        for (int i = 0; i < randMat11.mat.length; i++) {
            for (int j = 0; j < randMat12.mat[i].length; j++) {
                list.add(new MulRandMat1OneRow(randMat11, randMat12, ret, i, j));
            }
        }
        invokeAll(list);
    }
}
class RandMat1 {
    public int[][] mat;
    public RandMat1(int row, int col) {
        this.mat = new int[row][col];
    }
    public void initRandMat1(int min, int max) {
        SecureRandom secRand = new SecureRandom();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = secRand.nextInt(min, max);
            }
        }
    }
    public void outputRandMat1() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static RandMat1 plusRandMat1(RandMat1 randMat11, RandMat1 randMat12) {
        if (randMat11.mat.length != randMat12.mat.length || randMat11.mat[0].length != randMat12.mat[0].length) {
            return null;
        }
        RandMat1 ret = new RandMat1(randMat11.mat.length, randMat11.mat[0].length);
        RecursiveAction recursiveAction = new PlusRandMat1(randMat11, randMat12, ret, 0, randMat11.mat[0].length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(recursiveAction);
        return ret;
    }
    public static RandMat1 mulRandMat1(RandMat1 randMat11, RandMat1 randMat12) {
        if (randMat11.mat[0].length != randMat12.mat.length) {
            return null;
        }
        RandMat1 ret = new RandMat1(randMat11.mat.length, randMat12.mat[0].length);
        RecursiveAction recursiveAction = new MulRandMat1(randMat11, randMat12, ret);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(recursiveAction);
        return ret;
    }
}
class RandMat2 {
    public int[][] mat;
    public RandMat2(int row, int col) {
        this.mat = new int[row][col];
    }
    public void initRandMat2(int min, int max) {
        SecureRandom secRand = new SecureRandom();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = secRand.nextInt(min, max);
            }
        }
    }
    public void outputRandMat2() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static RandMat2 plusRandMat2(RandMat2 randMat21, RandMat2 randMat22) {
        if (randMat21.mat.length != randMat22.mat.length || randMat21.mat[0].length != randMat22.mat[0].length) {
            return null;
        }
        RandMat2 ret = new RandMat2(randMat21.mat.length, randMat21.mat[0].length);
        for (int i = 0; i < ret.mat.length; i++) {
            for (int j = 0; j < ret.mat[i].length; j++) {
                ret.mat[i][j] = randMat21.mat[i][j] + randMat22.mat[i][j];
            }
        }
        return ret;
    }
    public static RandMat2 mulRandMat2(RandMat2 randMat21, RandMat2 randMat22) {
        if (randMat21.mat[0].length != randMat22.mat.length) {
            return null;
        }
        RandMat2 ret = new RandMat2(randMat21.mat.length, randMat22.mat[0].length);
        for (int i = 0; i < randMat21.mat.length; i++) {
            for (int j = 0; j < randMat22.mat[i].length; j++) {
                for (int k = 0; k < randMat21.mat[i].length; k++) {
                    ret.mat[i][j] += randMat21.mat[i][k] * randMat22.mat[k][j];
                }
            }
        }
        return ret;
    }
}
public class Exp5 {
    public static void main(String[] args) {
        int row = 2000;
        int col = 2000;
        int minNum = Integer.MIN_VALUE;
        int maxNUm = Integer.MAX_VALUE;
        RandMat1 randMat11 = new RandMat1(row, col);
        RandMat1 randMat12 = new RandMat1(row, col);
        randMat11.initRandMat1(minNum, maxNUm);
        randMat12.initRandMat1(minNum, maxNUm);
        long begin11 = System.currentTimeMillis();
        RandMat1.plusRandMat1(randMat11, randMat12);
        long end11 = System.currentTimeMillis();
        System.out.println("并行相加：" + (end11 - begin11) + " ms");
        long begin12 = System.currentTimeMillis();
        RandMat1.mulRandMat1(randMat11, randMat12);
        long end12 = System.currentTimeMillis();
        System.out.println("并行相乘：" + (end12 - begin12) + " ms");
        RandMat2 randMat21 = new RandMat2(row, col);
        RandMat2 randMat22 = new RandMat2(row, col);
        randMat21.initRandMat2(minNum, maxNUm);
        randMat22.initRandMat2(minNum, maxNUm);
        long begin21 = System.currentTimeMillis();
        RandMat2.plusRandMat2(randMat21, randMat22);
        long end21 = System.currentTimeMillis();
        System.out.println("顺序相加：" + (end21 - begin21) + " ms");
        long begin22 = System.currentTimeMillis();
        RandMat2.mulRandMat2(randMat21, randMat22);
        long end22 = System.currentTimeMillis();
        System.out.println("顺序相乘：" + (end22 - begin22) + " ms");
    }
}