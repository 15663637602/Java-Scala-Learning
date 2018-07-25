package java8.lambda;

/**
 * @ClassName UDFFunction
 * @Description TODO
 * @Author yuqili
 * @Date 25/07/18  11:35
 * @Version 1.0
 **/
@FunctionalInterface
public interface UDFFunction<T, U, K, R> {
    R apply(T t, U u, K k);
}
