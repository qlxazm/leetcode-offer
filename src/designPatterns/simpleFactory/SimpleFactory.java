package designPatterns.simpleFactory;

/**
 * @author yd
 * @date 2020/3/25 11:43
 */
public class SimpleFactory {

    public static Computer makeComputer(String computerType) {
        Computer computer = null;
        switch (computerType.toLowerCase()) {
            case "mi":
                computer = new MiComputer();
                break;
            case "max":
                computer = new MacComputer();
                break;
            default:
                break;
        }
        return computer;
    }
}
