package algorithms;

/**
 * 给定两个数字， 求最大的 不能由这两个数字的倍数组成的 数字
 */
public class ImpossibleSugarNum {

    private static int N = 100 * 1000;

    // 找到连续出现a个1的那个区间。那么它们之前的那个是 0 的位置就是impossible Number
    private static int se(byte[] da, int a){
        int n = 0;
        for (int i=0; i<da.length; i++){
            if(da[i] == 1){
                n++;
                if(n>=a) return i - a;
            }else {
                n = 0;
            }
        }
        return -1;
    }

    public static void f(int a, int b) {
        byte[] da = new byte[N];
        for (int i = 0; i < N / a; i++) {
            for (int j = 0; j < N / b; j++) {
                if (i * a + j * b < N) da[i * a + j * b] = 1;
            }
        }
        System.out.println(se(da, a<b? a:b));

    }

    public static void main(String[] args) {
        f(10, 13);
    }
}
