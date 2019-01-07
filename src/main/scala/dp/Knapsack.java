package dp;

import java.util.HashMap;

/**
 * define TODO
 *
 * @author yuqili
 * Date 05/01/19  12:10
 * @version 1.0
 **/
public class Knapsack {
    public static void main(String[] args){
        int[] weights = {10, 20, 30, 30};
        int[] values = {60, 100, 120, 110};
        final int MAX_WEIGHT = 50;
        System.out.println(naiveRec(MAX_WEIGHT, weights, values));
        System.out.println(naiveRecWithCache(MAX_WEIGHT, weights, values));
        int[] weightss = {1, 2, 3};
        int[] valuess = {6, 10, 12};
        System.out.println(knapsack(5, weightss, valuess));
    }

    // Top down solution
    private static int naiveRec(int max_weight, int[] weights, int[] values) {
        return naiveRec(max_weight, weights, values, 0);
    }

    private static int naiveRec(int max_weight, int[] weights, int[] values, int index) {
        if (index >= weights.length) return 0;
        if (weights[index] > max_weight)
            return naiveRec(max_weight, weights, values, index + 1);
        return Math.max(naiveRec(max_weight - weights[index], weights, values, index + 1) + values[index],
                naiveRec(max_weight, weights, values, index + 1));
    }

    private static int naiveRecWithCache(int max_weight, int[] weights, int[] values) {
        return naiveRecWithCache(max_weight, weights, values, 0, new HashMap<>());
    }

    private static int naiveRecWithCache(int max_weight, int[] weights, int[] values, int index, HashMap<String, Integer> cache) {
        if (index >= weights.length) return 0;
        if (cache.containsKey(index+":"+max_weight)) {
            return cache.get(index+":"+max_weight);
        }
        if (weights[index] > max_weight) {
            int res = naiveRecWithCache(max_weight, weights, values, index + 1, cache);
            cache.put(index+":"+max_weight, res);
            return res;
        }
        int temp1 = naiveRecWithCache(max_weight, weights, values, index + 1, cache);
        int temp2 = naiveRecWithCache(max_weight - weights[index], weights, values, index + 1, cache) + values[index];
        if (temp1 >= temp2) {
            cache.put(index+":"+max_weight, temp1);
            return temp1;
        } else {
            cache.put(index+":"+max_weight, temp2);
            return temp2;
        }
    }
    // bottom up 需要值是离散的
    // https://www.youtube.com/watch?v=YRBON9sIZ2Y&t=1531s
    public static int knapsack(int max_weight, int[] weights, int[] values) {
        int[][] cache = new int[weights.length + 1][max_weight + 1];
        for(int i=1;i<weights.length+1;i++) {
            for(int j=1;j<=max_weight;j++) { //j is current max weight: from 1 to 5
                if (weights[i-1] > j) cache[i][j] = cache[i-1][j];
                else
                    cache[i][j] = Math.max(
                            cache[i - 1][j],
                            cache[i-1][j-weights[i-1]] + values[i - 1]
                    );
            }
        }
        return cache[weights.length][max_weight];
    }
}
