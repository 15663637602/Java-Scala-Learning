package algorithms;

import java.math.BigDecimal;
import java.math.MathContext;

public class Decimall {
    public static void main(String[] args) {
        // 四舍六入五成双
        // 3.150 -> 如果碰到这种， 就是五成双： 看 舍或者入之后的结果， 取结果是偶数的那个值


        BigDecimal a = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(6), new MathContext(100));
    }

}
