package algorithms;

import java.math.BigInteger;

public class Narcissus {

    private static BigInteger[] base = new BigInteger[10];

    // 计算 1~9每个数字的21次幂的结果并存到数组中
    private static BigInteger calcu_21power(int i){
        BigInteger a = BigInteger.ONE;
        for(int n=0; n<21; n++) a = a.multiply(BigInteger.valueOf(i));
        return a;
    }

    // a: 一个数组，用于保存0~9每个数字出现的次数
    // k: 当前要处理的那个数字
    // sum: 还剩余的位数
    private static void f(int[] a, int k, int sum){

        if(k > a.length - 1) return;

        if(sum == 0){
            test(a);
            return;
        }

        if(k == a.length - 1){
            a[k] = sum;
            test(a);
            return;
        }

        for(int i=0; i<=sum; i++){
            a[k] = i;
            f(a, k+1, sum - i);
            a[k] = 0; // 回溯
        }
    }

    private static void test(int[] a) {
        BigInteger b = BigInteger.ZERO;

        for(int i=0; i<a.length; i++){
            b = b.add(base[i].multiply(BigInteger.valueOf(a[i])));
        }

        String s = b.toString();
        if(s.length() != 21) return;

        // 把 s 的每位上出现的数字加和， 求每个数字出现的次数，再与 a数组比较
        int[] c = new int[10];
        for(int i=0; i<s.length(); i++){
            c[s.charAt(i) - '0'] ++;
        }
        for(int i = 0; i< 10; i++){
            if(a[i] != c[i]) return;
        }

        System.out.println(b);

    }


    public static void main(String[] args) {
        for(int i=0; i<base.length; i++){
            base[i] = calcu_21power(i);
        }
        // 0~9每个数字在结果中出现的次数
        int[] a = new int[10];

        f(a, 0, 21);
    }
}
