package algorithms;

public class Pirate {
    public static void main(String[] args) {
        for(int a=20; a>= 1; a--){
            for(int b=a-1; b>=1; b--){
                for(int c=b-1; c>=1; c--){
                    for(int d=c-1; d>=1; d--){
                        if((1.0/a + 1.0/b + 1.0/c + 1.0/d) == 1)
                            System.out.println(a +" "+ b +" "+ c +" "+ d);
                    }
                }
            }
        }
    }
}
