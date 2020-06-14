package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:05
 */
public class MiComputer implements Computer {
    @Override
    public void setOperation() {
        System.out.println("小米电脑用Windows系统");
    }
}
