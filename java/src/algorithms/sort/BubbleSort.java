package algorithms.sort;

/**
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，
 * 将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，
 * 如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        bubblesort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubblesort(int [] arr){
        for (int i=0; i<arr.length - 1; i++){
            for (int j=0; j<arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
