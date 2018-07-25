package java8.lambda;

import java.util.function.BiFunction;

/**
 * @ClassName PeopleGenerator
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  10:55
 * @Version 1.0
 **/
public class PeopleGenerator {
    public static void main(String[] args) {
        BiFunction<Integer, String, People> f = (age, name) -> new People(age, name);
        BiFunction<Integer, String, People> f2 = People::new; //use predefined functional interface to refer method (this method is the constructor in People class)
        People p1 = f2.apply(23, "lihao");
        // Function with more than 2 parameters
        UDFFunction<String, Integer, String, People> udfFunction = People::new;
    }
}
