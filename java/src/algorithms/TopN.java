package algorithms;

public class TopN {
    public static void main(String[] args) {
        int arr[] = {34,1, 2, -3,4, 5, 7, 4, 5 ,3 ,9 ,0};
        int[] a = TopN.topN(arr, 4);
        for (int i : a){
            System.out.print(i + " ");
        }
    }

    public static int[] topN(int[] arr, int n){
        if (arr.length <= n) return arr;
        int[] a = new int[n];
        for (int i : arr){
            for (int j=0;j<n;j++){
                if (a[j] == 0){
                    a[j] = i;
                    break;
                }else if (i > a[j]){
                    for (int m=n - 1;m>j;m--){
                        a[m] = a[m - 1];
                    }
                    a[j] = i;
                    break;
                }
            }
        }
        return a;
    }
}
