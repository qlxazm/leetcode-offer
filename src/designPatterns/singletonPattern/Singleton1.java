package designPatterns.singletonPattern;

/**
 * 饿汉模式
 */
public class Singleton1 {
    private Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public Singleton1 getInstance() {
        return instance;
    }
}
