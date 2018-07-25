package algorithms;

/*
3:  011
4:  100
5:  101
    010
 */
//实际上，当Nim和中包含至少一个1时，该实例为一个胜局；相应的，当Nim和中只包含0时，该实例为一个败局
//所以对于先走的玩家来说，这是一个胜局，走法为改变三个位串中的一个，使Nim和仅包含0，例如从第一个堆中拿走2个。


import java.util.Scanner;

// 高僧阶梯问题
public class Nimm {

    public static boolean f(int[] x) {
        String[] y = new String[x.length / 2];
        int m = 0;
        for (int i = 0; i < x.length / 2; i++) {
            y[i] = Integer.toBinaryString(x[i * 2 + 1] - x[i * 2] - 1);
            if (y[i].length() > m) m = y[i].length();
        }
        for (int i = 0; i < m; i++) {
            boolean tag = true;
            for (int j = 0; j < y.length; j++) {
                int k = y[j].length() - (m - i);
                if (k >= 0 && y[j].charAt(k) == '1') tag = !tag;
            }
            if (tag == false) return false;
        }
        return true;
    }

    public static void test(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int k = x[i] + 1; k < x[i + 1]; k++) {
                int old = x[i];
                x[i] = k;
                try {
                    if (f(x))
                        System.out.println(old + "->" + k);
                } finally {
                    x[i] = old;
                }
            }
        }
    }

    // 输入：每个和尚所在的阶梯位置；
    // 目的：到最后， 谁无法再移动和尚的话，就算那个人输
    // 输出：A -> B   把第A个阶梯的和尚移动到第B个阶梯。
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] ss = scan.nextLine().split(" ");
        int[] x = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            x[i] = Integer.parseInt(ss[i]);
        }

        test(x);
    }
}
