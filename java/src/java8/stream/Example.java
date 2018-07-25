package java8.stream;

import java8.lambda.People;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName Example
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  12:23
 * @Version 1.0
 **/
public class Example {

    /**
     * List<People> is sequence of elements, people is source, filter/sorted/map... are data processing operations.
     * @param people
     * @return
     */
    public static List<String> getSortedName(List<People> people){
        // for parallel execution -> use people.parallelStream()
        return people.stream().filter(p -> p.getAge() < 20).sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .map(People::getName).collect(toList()); // pipelining
    }

    public static void main(String[] args) {
        List<People> p = Arrays.asList(new People(13, "xiao"), new People(15, "da"), new People(23, "dada"));

        getSortedName(p).forEach(System.out::println);
    }
}