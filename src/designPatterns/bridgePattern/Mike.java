package designPatterns.bridgePattern;

/**
 * 扮演的角色是：ConcreteImplementor
 */
public class Mike implements ICoffeeAdditives {
    @Override
    public void addSomething() {
        System.out.println("加奶");
    }
}
