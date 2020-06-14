package designPatterns.bridgePattern;

/**
 * @author yd
 * @date 2020/3/25 14:38
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        RefinedCoffee largeCoffee = new LargeCoffee(new Mike());
        largeCoffee.orderCoffee(2);
    }
}
