package java8;

/**
 * @author qian
 * @date 2020/2/25 16:11
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int t) {
        return Math.sqrt(t);
    }
}
