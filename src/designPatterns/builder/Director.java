package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:21
 */
public class Director {

    public void makeComputer(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setKeyBoard();
        builder.setDisplay();
    }
}
