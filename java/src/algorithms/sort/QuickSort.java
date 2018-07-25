package algorithms.sort;

public class QuickSort {

    public static void quickSort(int[] arr){
        if(arr == null) throw new RuntimeException("Null Array");
        _quickSorts(0, arr.length - 1, arr);
    }

    private static void _quickSorts(int l, int h, int[] arr){
        if(l > h) return;
        int low = l;
        int high = h;
        int p = arr[low];
        while (low < high) {
            while (p <= arr[high] && low < high){
                high--;
            }
            if (low < high){
                arr[low] = arr[high];
                low++;
            }
            while (p > arr[low] && low < high) {
                low ++;
            }
            if(low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = p;
        _quickSorts(l, low - 1, arr);
        _quickSorts(low + 1, h, arr);
    }

    private static void _sort(int a[], int l, int h) {
        int low, high, index;
        if (l > h) {
            return;
        }
        low = l;
        high = h;
        index = a[low]; // 用子表的第一个记录做基准
        while (low < high) { // 从表的两端交替向中间扫描
            while (low < high && a[high] >= index)
                high--;
            if (low < high)
                a[low++] = a[high];// 用比基准小的记录替换低位记录
            while (low < high && a[low] < index)
                low++;
            if (low < high) // 用比基准大的记录替换高位记录
                a[high--] = a[low];
        }
        //　到这里, low 和 high 是相等的
        a[low] = index;// 将基准数值替换回 a[i]
        _sort(a, l, low - 1); // 对低子表进行递归排序
        _sort(a, low + 1, h); // 对高子表进行递归排序

    }

    public static void main(String[] args) {
        int arr[] = {34,1, 2, -3,4, 5, 7, 4, 5 ,3 ,9 ,0};
        //QuickSort.sort(arr, 0, arr.length - 1);
        QuickSort.quickSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
