package algorithms;

// M个A和N个B，求一共有几种不同的组合方式
public class MANB {

    public static int f(int m, int n){
        if(m == 0 || n == 0) return 1;
        return f(m - 1, n) + f(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(MANB.f(3,2));
    }
}
