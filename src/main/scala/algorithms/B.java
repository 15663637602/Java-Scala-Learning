package algorithms;

public class B {
    public static int addAll(int[] a){
        return adds(a, a.length - 1, 0);
    }

    public static int adds(int[] a, int i, int sum){
        if(i < 0) return sum;
        return adds(a, i-1, sum + a[i]);
    }

    public static int addAll2(int[] a, int begin){
        if(begin > a.length - 1) return 0;
        int x = addAll2(a, begin + 1);
        return x + a[begin];
    }

    public static int addAll3(int[] a){
        return adds3(a, 0, a.length - 1);
    }

    public static int adds3(int[] a, int s, int e){
        int start = s;
        int end = e;
        int m = (start + end) / 2;
        if((end - start) == 1) return a[start] + a[end];
        if(end == start) return a[start];
        return adds3(a, start, m) + adds3(a, m + 1, end);
    }

    public static void main(String[] args) {
        int[] p = {1,2,3,4,5,6,7};
        System.out.println(addAll(p));
        System.out.println(addAll2(p, 0));
        System.out.println(addAll3(p));
    }

}
