package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:12
 */
public class MacBookBuilder implements ComputerBuilder {

    private Computer computer;

    public MacBookBuilder(String cpu, String ram) {
        this.computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyboard("这是苹果的键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("这是苹果的显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
