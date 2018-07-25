package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 把区间分成长度为 1 的许多个小区间
public class IntervalLine {
    private int begin;
    private int end;
    private boolean isOver = false; // 是否被覆盖

    private IntervalLine left;
    private IntervalLine right;

    public IntervalLine(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    public void split(){
        if(end - begin < 2) return;
        int mid = (begin + end) / 2;
        left = new IntervalLine(begin, mid);
        right = new IntervalLine(mid, end);
        left.split();
        right.split();
    }

    public void add(int begin, int end){
        if(isOver) return; // 已经被完全覆盖了
        if(end <= this.begin || begin > this.end) return; // 不相交
        if(begin <= this.begin && end >= this.end){
            isOver = true;
            return;
        }

        if(left != null) left.add(begin, end);
        if(right != null) right.add(begin, end);
    }

    public int get_over_length(){
        if(isOver) return end - begin;
        int len = 0;
        if(left != null) len += left.get_over_length();
        if(right != null) len += right.get_over_length();
        return len;
    }

    public static void main(String[] args) throws Exception {
        IntervalLine root = new IntervalLine(0, 20000);
        root.split();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        for (;;){
            String s = br.readLine();
            if(s==null) break;
            String[] ss = s.trim().split(",");
            root.add(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]));
        }
        br.close();

        System.out.println(root.get_over_length());
    }
}
