package probability;

public class SameBirth {

    static void f(int n, int N){
        int count = 0;
        for (int i=0; i < N; i++){
            byte[] b = new byte[365];
            for(int k=0; k<n; k++){
                int r = (int) (Math.random()*365);
                if(b[r] == 1){
                    count ++;
                    break;
                }else{
                    b[r] = 1;
                }
            }
        }
        System.out.println(count * 100 / N);
    }

    public static void main(String[] args) {
        // 30个人，有相同生日的概率是多少
        f(30, 10000*100);
    }
}
