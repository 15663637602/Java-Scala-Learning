package dp;

import java.util.HashMap;

/**
 * define TODO
 *
 * @author yuqili
 * Date 05/01/19  11:46
 * @version 1.0
 **/
public class Fibonacci {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(count(n, new HashMap<>()));
    }

    private static int count(int n, HashMap<Integer, Integer> m) {
        if (n <= 2) {
            return 1;
        }
        if (m.containsKey(n)) {
            return m.get(n);
        }
        int res = count(n -1, m) + count(n - 2, m);
        m.put(n, res);
        return res;
    }
}
