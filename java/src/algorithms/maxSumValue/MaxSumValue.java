package algorithms.maxSumValue;

import java.lang.reflect.Array;

// 给定一个数组， 返回 和 是最大的连续的子数组
public class MaxSumValue {
    // Brute force   O(n) = n^3
    public static void method1(int[] arr){
        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        for (int i=0; i<=arr.length - 1; i++){
            for (int j=i; j<arr.length - 1; j++){
                int curSum = 0;
                for (int k = i; k<=j; k++){
                    curSum += arr[k];
                }
                if(curSum > maxSum){
                    maxSum = curSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("maxSum: " + maxSum);
        System.out.println("start: "+start + " end: " + end);
    }

    // Dichotomy  O(n) = nlog(n)
    public static int method2(int l, int h, int[] arr){
        if(l > h) return 0;
        if(l == h) return arr[l];
        int low = l;
        int high = h;
        int middle = (low + high) / 2;
        int leftSum = method2(low, middle, arr);
        int rightSum = method2(middle + 1, high, arr);
        // 计算横跨中间的子数组
        int maxtoLeft = arr[middle];
        int sumLeft = arr[middle];
        for (int i=middle - 1; i >= low; i--){
            sumLeft += arr[i];
            maxtoLeft = Math.max(sumLeft, maxtoLeft);
        }
        int maxtoRight = arr[middle + 1];
        int sumRight = arr[middle + 1];
        for (int i = middle + 2; i <= high; i++){
            sumRight += arr[i];
            maxtoRight = Math.max(maxtoRight, sumRight);
        }
        int midSum = maxtoLeft + maxtoRight;

        return Math.max(Math.max(leftSum, midSum), Math.max(rightSum, midSum));

    }

    // Dynamic programming    O(n) = n
    public static void method3(int[] arr){
        int[] s = new int[arr.length];
        // s[p] = max(s[p - 1] + arr[p], arr[p])
        // s[i] 是 以arr[i] 为结尾的最大的子数组
        s[0] = arr[0];
        for (int i=1; i<=arr.length - 1; i++){
            s[i] = Math.max(s[i-1] + arr[i], arr[i]);
        }
        int maxSum = s[0];
        for (int i=1; i<s.length;i++){
            if(s[i] > maxSum) maxSum = s[i];
        }
        System.out.println(maxSum);
    }

    // Dynamic programming    O(n) = n
    public static void method4(int[] arr){
        Record[] a = (Record[]) Array.newInstance(Record.class, arr.length);
        // s[p] = max(s[p - 1] + arr[p], arr[p])
        // s[i] 是 以arr[i] 为结尾的最大的子数组
        a[0] = new Record(0, arr[0]);
        for (int i=1; i<=arr.length - 1; i++){
            int cur = a[i - 1].getValue() + arr[i];
            if ( cur > arr[i]){
                a[i] = new Record(a[i-1].getStart_pos(), cur);
            }else {
                a[i] = new Record(i, arr[i]);
            }
        }
        int maxSum = a[0].getValue();
        int start_pos = 0;
        int end_pos = 0;
        for (int i=1; i<a.length;i++){
            if(a[i].getValue() > maxSum){
                maxSum = a[i].getValue();
                start_pos = a[i].getStart_pos();
                end_pos = i;
            }
        }
        System.out.println("start pos: "+start_pos + " end pos: "+end_pos+" value: "+maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, 10, -4, -7, -2, -5};
        MaxSumValue.method1(arr);
        int result = MaxSumValue.method2(0, arr.length - 1, arr);
        System.out.println(result);
        MaxSumValue.method3(arr);
        MaxSumValue.method4(arr);
    }
}

class Record{
    private int start_pos;
    private int value;

    public Record(int start_pos, int value) {
        this.start_pos = start_pos;
        this.value = value;
    }

    public int getStart_pos() {
        return start_pos;
    }

    public void setStart_pos(int start_pos) {
        this.start_pos = start_pos;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
