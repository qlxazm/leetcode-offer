package designPatterns.singletonPattern;

/**
 * 双重校验锁
 */
public class Singleton2 {

    private volatile Singleton2 instance;

    private Singleton2() {}

    public Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
