package algorithms;

public class Test {
    public static void main(String[] args) {
        int n = Test.detectNum(10, 13);
        System.out.println(n);
    }

    private static int detectNum(int a, int b){
        final int N = 1000 * 100;
        byte[] da = new byte[N];
        for (int i=0; i<=N/a; i++){
            for (int j=0; j<=N/b; j++){
                if ((i*a + j*b) < N) da[i*a + j*b] = 1;
            }
        }
        return getNum(da, a < b? a: b);
    }

    private static int getNum(byte[] b, int n){
        int c = 0;
        for (int i=0; i<b.length; i++){
            if (b[i] == 1){
                c++;
                if (c == n){
                    return i - n;
                }
            }else {
                c=0;
            }
        }
        return -1;
    }
}
