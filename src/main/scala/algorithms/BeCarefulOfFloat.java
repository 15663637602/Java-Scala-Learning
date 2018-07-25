package algorithms;

public class BeCarefulOfFloat {

    // 小心浮点数
    public static void main(String[] args) {
        // 浮点数： 足够接近就行了 |a-b| < seta
        System.out.println(0.2 + 0.1 == 0.3);
        System.out.println(Math.abs(0.2 + 0.1 - 0.3) < 1E-10);
        // IEEE754  5 个特殊值
        // 浮点数除以0：
        double a = 3.0/0;
        System.out.println(a + 1);
        System.out.println(1/a);
        System.out.println(a*-1);
        System.out.println(1/(-a));
        System.out.println(a-a); // NaN 不是一个数字
    }
}
