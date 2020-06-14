package javaSeTest;

/**
 * @author qian
 * @date 2020/2/19 16:54
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized");
        }
    }
}
