package designPatterns.strategy;

/**
 * @author yd
 * @date 2020/3/25 8:35
 */
public class StrategyDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(1, 2));

        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(1, 2));

        context = new Context(new OperationSubstract());
        System.out.println(context.executeStrategy(1, 2));
    }
}
