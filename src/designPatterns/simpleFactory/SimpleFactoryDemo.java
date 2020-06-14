package designPatterns.simpleFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yd
 * @date 2020/3/25 11:14
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Computer computer = SimpleFactory.makeComputer("mi");
        computer.setOperationSystem();
    }
}
