package algorithms.zeroSubArray;

public class ZeroSubArray {
    // 求 和 最接近 0 的连续子数组, 要求O(n) = nlog(n)
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        ZeroSubArray.method(arr);
    }

    public static void method(int[] arr){
        // 求出以a[0].....a[n-1] 为结尾的子数组的和
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i=1; i<= arr.length - 1; i++){
            sum[i] = sum[i - 1] + arr[i];
        }
        QuickSort.quickSort(sum);
        int min = sum[1] - sum[0];
        for (int i=1; i< sum.length - 1; i++){
            int cur = sum[i+1] - sum[i];
            if(cur < min){
                min = cur;
            }
        }
        System.out.println(min);
    }
}
