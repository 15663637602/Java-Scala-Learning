package niuke;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Bahe {
    public static void main(String[] args){
        int[] array={10,23,41,12};
        int n=array.length;
        System.out.println(min(array,n));
    }
    public static int min(int[] array,int n){
        if(array==null || array.length<1 ||n<1){
            return -1;
        }
        int result=0;
        for(int i:array){
            result+=i;
        }
        int sum=result/2;
        int[][] dp=new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(j-array[i-1]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-array[i-1]]+array[i-1]);
                }
            }
        }
        return result-dp[n][sum]*2;
    }
    public void test(){
        Map<Integer, Integer> m = new HashMap<>(100, 70);
        TreeMap<Integer, Integer> m2 = new TreeMap<>((o1, o2) -> 0);
        m2.subMap(1,2);
    }

}
