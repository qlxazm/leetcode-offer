package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:06
 */
public class MacComputer implements Computer {
    @Override
    public void setOperation() {
        System.out.println("MacBook用Mac系统");
    }
}
