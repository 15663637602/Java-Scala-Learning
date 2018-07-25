package algorithms.pivotArray;

public class PivotArray {
    public static void main(String[] args) {
        // 找出旋转后数组的最小值， 假设没有重复元素
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        PivotArray.dichotomy(arr);
    }

    public static void dichotomy(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low < high){
            mid = (low + high) / 2;
            if (arr[mid] > arr[high]){
                low = mid + 1;
            }else if (arr[mid] < arr[high]) {
                high = mid;
            }
        }
        System.out.println(arr[low]);

    }
}
