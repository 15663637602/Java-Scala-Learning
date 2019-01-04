package algorithms;

import java.util.*;

public class Permutations {

    public static void f(String a) {
        List<String> l = new ArrayList<>();
        perm("", a, l);
        Set<String> set = new TreeSet<>(l);
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void perm(String pre, String s, List<String> l) {
        if (s.length() == 0) {
            l.add(pre);
        }
        for (int i = 0; i < s.length(); i++) {
            perm(pre + s.substring(i, i + 1), s.substring(0, i) + s.substring(i + 1), l);
        }
    }


    public static void f2(String a) {
        perm2(a.toCharArray(), 0);
    }

    public static void perm2(char[] a, int k) {

        if (k == a.length - 1) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        // 让第一位的数字与后面的数字交换，交换后再递归的用该函数（k+1 ~ a.length)
        for (int i = k; i < a.length; i++) {
            {// 试探
                char temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
            perm2(a, k + 1);
            {// 回溯
                char temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    // filter duplicated permutations.
    public static ArrayList<String> permutation(String str){
        if(str == null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        list = per(chars, 0, list);
        Collections.sort(list);
        return list;
    }

    public static ArrayList<String> per(char[] chars, int index, ArrayList<String> list){
        if(index == chars.length - 1){
            list.add(String.valueOf(chars));
        }
        for(int i = index; i < chars.length; i++){
            if(i!=index && chars[i] == chars[index]) continue;
            {
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
            }
            per(chars, index + 1, list);
            {
                char temp = chars[i];
                chars[i] = chars[index];
                chars[index] = temp;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String a = "aabc";
        Permutations.f(a);
        System.out.println("----------------------");
        ArrayList<String> b = Permutations.permutation("aabc");
        b.forEach(System.out::println);
    }
}