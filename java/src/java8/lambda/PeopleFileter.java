package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName PeopleFileter
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  10:49
 * @Version 1.0
 **/
public class PeopleFileter {
    public static void main(String[] args) {
        List<People> p = Arrays.asList(new People(13, "xiao"), new People(15, "da"), new People(23, "dada"));
        Predicate<People> pred = pp -> pp.getAge() > 14;
        List<People> p2 = new ArrayList<>();
        for (People people: p){
            if (pred.test(people)){
                p2.add(people);
            }
        }
        p2.forEach(System.out::println);
    }
}
