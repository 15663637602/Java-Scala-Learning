package algorithms;

public class Factorization {

    // 对n进行加法划分
    // a缓冲， k是数组当前要记录的下一个值的位置
    public static void f(int n, int[] a, int k){
        if(n <= 0){
            for(int i=0; i < k; i++){
                System.out.print(a[i] +" ");
            }
            System.out.println();
            return;
        }
        for(int i = n; i > 0; i--){
            // 剔除重复的结果, 降序
            if(k > 0&&a[k - 1] < i) continue;

            a[k] = i;
            f(n - i, a, k + 1);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] a = new int[n];
        f(n, a, 0);
    }
}
