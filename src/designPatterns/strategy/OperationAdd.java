package designPatterns.strategy;

/**
 * @author yd
 * @date 2020/3/25 8:37
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
