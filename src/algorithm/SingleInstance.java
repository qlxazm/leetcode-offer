package algorithm;

/**
 */
public class SingleInstance {

    private SingleInstance() {}

    private static class InstanceHolder{
        static final SingleInstance instance = new SingleInstance();
    }

    public static SingleInstance getInstance() {
        return InstanceHolder.instance;
    }
}
