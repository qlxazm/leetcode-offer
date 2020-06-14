package designPatterns.singletonPattern;

/**
 * 使用静态内部类实现
 */
public class Singleton3 {

    private Singleton3() {}

    private static class SingletonHolder{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
