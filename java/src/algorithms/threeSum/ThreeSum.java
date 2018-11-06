package algorithms.threeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * define TODO
 *
 * @author yuqili
 * Date 26/10/18  11:28
 * @version 1.0
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num); //排序
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            if (i == 0 || (num[i] != num[i-1])) {
                //两个指针,并且头指针从i + 1开始，防止加入重复的元素
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //元素相同要后移，防止加入重复的 list
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] a = {0,0,0};
        List<List<Integer>> res = new ThreeSum().threeSum(a);
        System.out.println(res.size());
        for(List<Integer> l : res) {
            System.out.println(l.toString());
        }
    }
}
