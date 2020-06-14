package designPatterns.bridgePattern;

import java.util.Random;

/**
 * 扮演的角色是：RefinedAbstraction
 */
public abstract class RefinedCoffee extends Coffee{

    public RefinedCoffee(ICoffeeAdditives additives) {
        super(additives);
    }

    public void checkQuality() {
        Random ran = new Random();
        System.out.println(String.format("%s添加%s",
                additives.getClass().getSimpleName(),
                ran.nextBoolean() ? "正常" : "太多"));
    }
}
