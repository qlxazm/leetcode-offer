package designPatterns.bridgePattern;

/**
 * 扮演的角色是：Abstraction
 */
public abstract class Coffee {

    /**
     * 咖啡口味
     */
    protected ICoffeeAdditives additives;

    public Coffee(ICoffeeAdditives additives) {
        this.additives = additives;
    }

    /**
     * 预定咖啡
     * @param count
     */
    public abstract void orderCoffee(int count);
}
