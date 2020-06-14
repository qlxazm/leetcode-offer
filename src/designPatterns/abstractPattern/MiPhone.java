package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:06
 */
public class MiPhone implements MobilePhone {
    @Override
    public void setOperation() {
        System.out.println("小米手机用Android系统");
    }
}
