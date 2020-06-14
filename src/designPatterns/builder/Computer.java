package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:07
 */
public class Computer {

    /**
     * 必填参数
     */
    private String cpu;
    /**
     * 必填参数
     */
    private String ram;
    /**
     * 必填参数
     */
    private int usbCount;
    /**
     * 可选参数
     */
    private String keyboard;
    /**
     * 可选参数
     */
    private String display;

    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
