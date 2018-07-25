package algorithms;

public class NthPrimeNum {
    // 求第100001个素数
    public static void main(String[] args) {
        int N = 10 * 1000 * 1000;
        byte[] a = new byte[N];

        // 为什么i要小于N/2: 因为在目前N个长度数组中，过了一半之后的数，如果还没有被置为1，就只能认为它是素数了，它乘以最小的2都会越界。
        for(int i = 2; i<N/2; i++){
            if(a[i] == 1) continue;

            // k表示当前数乘以k得到的数。
            for(int k = 2; k < N/i; k++){
                if(i*k < N) a[i*k] = 1;
            }
        }

        int m = 0;
        int x = 100001;
        for(int i=2; i<N; i++){
            if(a[i] == 0){
                m++;
                if(m==x) System.out.println(i + "");
            }
        }

        System.out.println("m= " + m);

    }


}
