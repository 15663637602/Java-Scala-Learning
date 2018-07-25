package algorithms.randomAlg;

/**
 * @ClassName Birth
 * @Description 30 个人的班级，求出现生日重复的概率
 * @Author yuqili
 * @Date 19/07/18  12:02
 * @Version 1.0
 **/
public class Birth {
    public static void main(String[] args) {
        final int N = 1000 * 100;
        int n = 0;
        for (int i=0; i < N; i++){
            int[] x = new int[365];
            for (int j=0; j< 30; j++){
                int p = (int) (Math.random()*365);
                if (x[p] == 1){
                    n++;
                    break;
                }else {
                    x[p] = 1;
                }
            }
        }
        System.out.println((double)n / N);
    }
}
