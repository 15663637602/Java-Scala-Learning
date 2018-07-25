package algorithms;

public class FetchBalls {
    // fetch m balls from the total number of n, how many different results.
    public static int f(int n, int m){
        if(n < m) return 0;
        if(n == m) return 1;
        if(m <= 0) return 1;
        // 两种情况， 取当前的这个球(m - 1)  或者不取当前的这个球(m)
        return f(n - 1, m - 1) + f(n - 1, m);
    }

    public static void main(String[] args) {
        System.out.println(FetchBalls.f(10, 3));
    }
}
