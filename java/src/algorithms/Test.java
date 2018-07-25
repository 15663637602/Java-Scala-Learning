package algorithms;

public class Test {
    public static void main(String[] args) {
        int arr[] = {34,1, 2, -3,4, 5, 7, 4, 5 ,3 ,9 ,0};
        Test.bubbleSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i=0; i< arr.length - 1; i++){
            for (int j=0; j <arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
