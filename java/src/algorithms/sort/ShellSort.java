package algorithms.sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author yuqili
 * @Date 19/07/18  17:02
 * @Version 1.0
 **/
public class ShellSort {

    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < data.length; i++) {
                 // System.out.println("i:" + i);
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] {34,1, 2, -3,4, 5, 7, 4, 5 ,3 ,9 ,0};
        shellSortSmallToBig(data);
        System.out.println(Arrays.toString(data));
    }
}
