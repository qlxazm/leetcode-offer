package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:10
 */
public class MiFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }

    @Override
    public MobilePhone makePhone() {
        return new MiPhone();
    }
}
