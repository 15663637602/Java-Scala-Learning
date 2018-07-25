package algorithms.sort;

/**
 * @ClassName SelectionSort
 * @Description 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @Author yuqili
 * @Date 19/07/18  16:36
 * @Version 1.0
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {34,1, 2, -3,4, 5, 7, 4, 5 ,3 ,9 ,0};
        SelectionSort.selectSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void selectSort(int[] arr){
        for (int i=0; i < arr.length; i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i + 1; j < arr.length; j++){
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
