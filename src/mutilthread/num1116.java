package mutilthread;

/**
 * @author qian
 * @date 2020/3/2 17:38
 */
public class num1116 {

    public static void main(String[] args) {
        IntConsumer consumer = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
