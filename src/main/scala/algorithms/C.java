package algorithms;

public class C {
    public static boolean isSame(String s1, String s2, int index){
        if(index >= s1.length()|| index >= s2.length()) return true;
        if(s1.length() != s2.length()) return false;
        if(s1.charAt(index) != s2.charAt(index)) return false;
        return isSame(s1, s2, index + 1);
    }
    //substirng(1)

    public static void main(String[] args) {
        System.out.println(C.isSame("asdd", "asds", 0));
    }
}
