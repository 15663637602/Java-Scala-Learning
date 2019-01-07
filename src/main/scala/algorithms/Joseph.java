package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * define 解决的是n个人排成一圈，这n个人的序号分别是0 ~ n-1，
 * 给定一个数m,从头开始报数，每报到m-1时，
 * 这个人出列，然后下个人从0开始报数，
 * 直到最后一个人留下，求最后一个人的序号
 *
 * @author yuqili
 * Date 05/01/19  16:31
 * @version 1.0
 **/
public class Joseph {
    public static int joseph(int n, int m){
        if(n == 0 || m == 0)
            return -1;
        if(n == 1 && m == 1)
            return -1;
        List<Integer> alist = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            alist.add(i);
        //初值设为-1，
        int index = -1;
        while(alist.size() > 1){
            index = (index+m)%alist.size();
            alist.remove(index);
            //从上一个位置开始计数
            index--;
        }
        return alist.get(0);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int totalNum = s.nextInt();
        System.out.print("请输入报数大小：");
        int cycleNum = s.nextInt();
        s.close();
        int a = joseph(totalNum, cycleNum);
        System.out.println("最后一个人的序号：" + a);
    }
}
