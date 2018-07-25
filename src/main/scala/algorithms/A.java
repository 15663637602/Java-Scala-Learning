package algorithms;

public class A {

    public void recur(int i){
        if(i >= 0){
            System.out.println(i);
            recur(i - 1);
        }

    }

    public static void main(String[] args) {
        A a = new A();
        a.recur(10);
    }
}
