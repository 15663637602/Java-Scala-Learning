package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName PeopleSort
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  11:49
 * @Version 1.0
 **/
public class PeopleSort {
    public static void main(String[] args) {
        List<People> p = Arrays.asList(new People(13, "xiao"), new People(15, "da"), new People(23, "dada"));

        p.forEach(System.out::println);

        System.out.println("====================================");

        p.sort((p1, p2) -> p2.getAge() - p1.getAge());

        p.forEach(System.out::println);

        System.out.println("====================================");

        // The comparing method of Comparator needs a function as input parameter
        /*
        public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
        {
            Objects.requireNonNull(keyExtractor);
            return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        }
         */
        p.sort(Comparator.comparing(People::getAge));
        p.forEach(System.out::println);
    }
}
