package algorithms.permutation;

public class Permutation {
    public static void main(String[] args) {
        String str = "aabc";
       Permutation.method("", str);
    }

    private static void method(String initStr, String restStr){
        if(restStr.length() == 0) System.out.println(initStr);
        for (int i=0; i<restStr.length(); i++){
            method(initStr + restStr.substring(i, i+1), restStr.substring(0, i) + restStr.substring(i+1));
        }
    }
}
