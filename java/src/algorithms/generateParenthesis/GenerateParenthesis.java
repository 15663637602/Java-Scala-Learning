package algorithms.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * define TODO
 *
 * @author yuqili
 * Date 09/11/18  16:38
 * @version 1.0
 **/
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int a = 0; a < n; a++)
                for (String left: generateParenthesis(a))
                    for (String right: generateParenthesis(n-1-a))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> l = GenerateParenthesis.generateParenthesis2(3);
        for (String s : l) {
            System.out.println(s);
        }
    }
}
