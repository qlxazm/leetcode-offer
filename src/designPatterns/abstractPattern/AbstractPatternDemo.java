package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:03
 */
public class AbstractPatternDemo {

    public static void main(String[] args) {
        // 使用苹果工厂类
        AbstractFactory appleFactory = new AppleFactory();
        Computer mac = appleFactory.makeComputer();
        MobilePhone iphone = appleFactory.makePhone();

        // 使用小米工厂类
        AbstractFactory miFactory = new MiFactory();
        Computer miComputer = miFactory.makeComputer();
        MobilePhone miPhone = miFactory.makePhone();
    }
}
