package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:10
 */
public interface ComputerBuilder {

    void setUsbCount();
    void setKeyBoard();
    void setDisplay();

    /**
     * 用来获取最终构建的对象
     * @return
     */
    Computer getComputer();
}
