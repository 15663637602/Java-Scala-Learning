package niuke;

import java.util.Scanner;

public class RemoveMinOcc {
    public static void main(String[] args) {
        System.out.println("adaad".replaceAll("a", "X"));
        System.out.println('A' - 0);
        System.out.println('a' - 0);
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] arr = new char[26];
            int minIndex = Integer.MAX_VALUE;
            for (Character c : str.toCharArray()) {
                arr[c - 'a'] ++;
                if (arr[c - 'a'] < minIndex) {
                    minIndex = arr[c - 'a'];
                }
            }
            for (int i =0; i< arr.length; i++) {
                if (arr[i] == minIndex) {
                    str = str.replaceAll(String.valueOf((char)(i + 97)), "");
                }
            }
        }
    }


}
