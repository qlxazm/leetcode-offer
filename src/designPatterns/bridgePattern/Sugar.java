package designPatterns.bridgePattern;

/**
 *
 */
public class Sugar implements ICoffeeAdditives {

    @Override
    public void addSomething() {
        System.out.println("加糖");
    }
}
