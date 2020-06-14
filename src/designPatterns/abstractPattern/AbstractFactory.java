package designPatterns.abstractPattern;

/**
 * @author yd
 * @date 2020/3/25 12:09
 */
public interface AbstractFactory {
    Computer makeComputer();
    MobilePhone makePhone();
}
