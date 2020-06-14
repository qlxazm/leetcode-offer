package designPatterns.simpleFactory;

/**
 * @author yd
 * @date 2020/3/25 11:42
 */
public class MacComputer implements Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("MacBook用苹果OS");
    }
}
