package algorithms;

public class FindMissing {

    // err_sum: 账目错误的和
    // a: 账目明细
    // k: 当前处理的位置
    // cur_sum: 当前的累加和
    // 输出所有可能的miss的组合情况
    public static void f(int err_sum, int[] a, int k, int cur_sum, boolean[] b){
        if(cur_sum > err_sum) return;
        if(cur_sum == err_sum){
            for(int i = 0; i <b.length; i++){
                if(b[i] == true) System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        if(k >= a.length) return;

        b[k] = false;
        f(err_sum, a, k+1, cur_sum, b);
        b[k] = true;
        f(err_sum, a, k+1, cur_sum + a[k], b);
        b[k] = false; // 回溯, 因为之前 试探着选了当前的数字， 所以在它结束之后需要 回溯一下
    }

    public static void main(String[] args) {
        int sum = 6;
        int[] a = {3,2,4,3,1};
        boolean[] b = new boolean[a.length];
        f(sum, a, 0, 0, b);
    }
}
