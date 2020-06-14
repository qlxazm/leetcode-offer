package designPatterns.simpleFactory;

/**
 * @author yd
 * @date 2020/3/25 11:41
 */
public class MiComputer implements Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("小米电脑用小米OS");
    }
}
