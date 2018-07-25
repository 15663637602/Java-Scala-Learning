package algorithms.sort;

/**
 * @ClassName InsertSort
 * @Description 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数找到相应位置并插入，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * @Author yuqili
 * @Date 18/07/18  16:31
 * @Version 1.0
 **/
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {34, 1, 2, -3, 4, 5, 7, 4, 5, 3, 9, 0};
        InsertSort.insertSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j=0; j<i; j++){
                if (temp <= arr[j]){
                    for (int m=i; m>j; m--){
                        arr[m] = arr[m - 1];
                    }
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
}
