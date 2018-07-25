package algorithms;

public class Revert {

    public static String revert(String str){
        if(str.length() == 0) return "";
        return str.charAt(str.length() - 1) + revert(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(Revert.revert(str));
    }
}
