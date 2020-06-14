package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:11
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }

    @Override
    public MobilePhone makePhone() {
        return new Iphone();
    }
}
