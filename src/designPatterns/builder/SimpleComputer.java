package designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yd
 * @date 2020/3/25 10:45
 */
public class SimpleComputer {
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

    @Override
    public String toString() {
        return "SimpleComputer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    private SimpleComputer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }


    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private int usbCount;
        private String keyboard;
        private String display;

        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public ComputerBuilder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }

        public ComputerBuilder setKeyBoard(String keyBoard) {
            this.keyboard = keyBoard;
            return this;
        }

        public ComputerBuilder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public SimpleComputer build() {
            return new SimpleComputer(this);
        }

    }

    public static void main(String[] args) {
        SimpleComputer computer = new ComputerBuilder("mac的CPU", "mac的RAM")
                .setKeyBoard("macbook的键盘")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}
