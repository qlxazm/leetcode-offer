package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:07
 */
public class Iphone implements MobilePhone {
    @Override
    public void setOperation() {
        System.out.println("苹果手机用IOS系统");
    }
}
