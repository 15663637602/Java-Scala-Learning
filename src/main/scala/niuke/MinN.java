package niuke;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * define TODO
 *
 * @author yuqili
 * Date 04/01/19  23:02
 * @version 1.0
 **/
public class MinN {

    static int ig = 0;

    public static void main(String[] args) {
        Integer[] n ={1,2,3,4};
        int num = 3;
        List<Integer> l = Arrays.asList(n);
        takeN("",num,l);
        System.out.println(ig);
    }

    private static void takeN(String s, int total, List<Integer> lst) {
//        if (s.length() == total) {
//            System.out.println(s);
//            i++;
//        }
//
//        for (int i = 0; i < lst.size(); i++) {
//            List<Integer> temp = new LinkedList<>(lst);
//            String n = s + temp.remove(i);
//            takeN(n, total, temp);
//        }
        for (int i = 0; i < lst.size(); i++) {
            //System.out.println("i="+i);
            List<Integer> templst=new LinkedList<>(lst);
            String str = s + templst.remove(i);
            if (total == 1) {
                System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可
                ig++;
            } else {
                int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上
                takeN(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合
            }
        }
    }

}
