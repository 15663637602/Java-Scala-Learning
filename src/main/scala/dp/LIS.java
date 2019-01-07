package dp;

/**
 * define Longest increment substring
 *
 * @author yuqili
 * Date 05/01/19  15:15
 * @version 1.0
 **/
public class LIS {
    // 非连续递增
    public static void lis(int[] L) {
        int n = L.length;
        int[] f = new int[n];//用于存放f(i)值；
        f[0] = 1;//以第a1为末元素的最长递增子序列长度为1；
        for (int i = 1; i < n; i++)//循环n-1次
        {
            f[i] = 1;//f[i]的最小值为1；
            for (int j = 0; j < i; j++)//循环i 次
            {
                if (L[j] < L[i] && f[j] > f[i] - 1)

                    f[i] = f[j] + 1;//更新f[i]的值。
            }
        }
        for (int i:f){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //连续递增
    public static void lis2(int a[]){
        int f[] = new int[a.length];
        f[0] = 1;
        for(int i =1 ; i < a.length; i++){
            f[i] = 1;
            if(a[i-1] < a[i] && f[i-1] + 1 > f[i] &&  a[i] > a[i-1]){
                f[i] = f[i-1] + 1;
            }
            if(f[i] > f[i-1]+1){
                f[i] = 1;
            }
        }
        for (int i:f){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] l = {186 ,186,  150,  200,  160,  130,  197,  200};
        int[] l2 = {200,  197,  130,  160,  200,  150,  186,  186};
        int[] l3 = {1,2,3,4,5,1,2,3,8};
        lis(l);
        lis(l2);
        lis(l3);
        lis2(l3);
    }
}
