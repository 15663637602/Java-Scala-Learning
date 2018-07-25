package algorithms;

import java.util.ArrayList;

public class Splitter {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 10000; i < 10060; i++){
            sb.append(i).append(" ");
        }
        String sample = sb.toString();
        ArrayList<String> list = new ArrayList<>();
        int pos = 0, end;
        while((end = sample.indexOf(" ", pos)) >= 0){
            list.add(sample.substring(pos, end));
            pos = end + 1;
        }
    }
}
