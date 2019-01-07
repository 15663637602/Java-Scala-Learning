package niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * define TODO
 *
 * @author yuqili
 * Date 05/01/19  15:43
 * @version 1.0
 **/
public class Paidui {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String tempString = null;
        String[] tempss = null;
        int[] nums = null;
        int n = -1,result = -1;

        while(in.hasNext()){
            tempString = in.nextLine().trim();
            n = Integer.parseInt(tempString.trim());

            tempString = in.nextLine().trim();
            tempss = tempString.split(" ");
            nums = new int[tempss.length];
            for(int i = 0 ; i< tempss.length;i++)
                nums[i] = Integer.parseInt(tempss[i].trim());
            process(nums, n);
        }
    }

    private static void process(int[] nums, int n) {
        int[] lis1 = lis(nums);
        int[] nums_reverse = reverse(nums);
        int[] lis2 = reverse(lis(nums_reverse));
        int[] sum = new int[lis2.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = lis1[i] + lis2[i];
        }

        Arrays.sort(sum);
        System.out.println(n - sum[sum.length - 1] + 1);
    }

    private static int[] lis(int[] nums) {
        int[] lis1 = new int[nums.length];
        lis1[0] = 1;
        for (int i=0; i<lis1.length; i++) {
            lis1[i] = 1; //min value is 1
            for (int j = 0; j<i;j++) { //和前面的数比较
                if (nums[i] > nums[j] && lis1[j] > lis1[i] - 1) {
                    lis1[i] = 1 + lis1[j];
                }
            }
        }
        return lis1;
    }

    private static int[] reverse(int[] a){
        int[] a_reverse = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            a_reverse[a_reverse.length -1 - i] = a[i];
        }
        return a_reverse;
    }

}
