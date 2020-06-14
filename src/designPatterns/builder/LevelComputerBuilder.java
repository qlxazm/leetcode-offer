package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:18
 */
public class LevelComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public LevelComputerBuilder(String cpu, String ram) {
        this.computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(3);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyboard("这是联想的键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("这是联想的屏幕");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
