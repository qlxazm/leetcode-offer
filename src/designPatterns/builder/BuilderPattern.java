package designPatterns.builder;

/**
 * @author yd
 * @date 2020/3/25 10:06
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director();
        MacBookBuilder macBookBuilder = new MacBookBuilder("mac的CPU", "mac的RAM");
        LevelComputerBuilder levelComputerBuilder = new LevelComputerBuilder("联想的CPU", "联想的RAM");

        // 使用创建者创建一个MacBook
        director.makeComputer(macBookBuilder);
        System.out.println(macBookBuilder.getComputer());

        // 使用创建者创建一个Level
        director.makeComputer(levelComputerBuilder);
        System.out.println(levelComputerBuilder.getComputer());

    }
}
