package mutilthread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qian
 * @date 2020/3/2 17:39
 */
public class ZeroEvenOdd {
    private int n;

    private volatile boolean isZero = true;
    private volatile AtomicInteger turn = new AtomicInteger(1);

    private static Lock lock = new ReentrantLock();
    private static final Condition ZERO_Condition = lock.newCondition();
    private static final Condition EVEN_Condition = lock.newCondition();
    private static final Condition ODD_Condition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(!isZero) {
                    ZERO_Condition.await();
                }
                printNumber.accept(0);
                if((turn.get() & 1) == 0) {
                    EVEN_Condition.signal();
                } else {
                    ODD_Condition.signal();
                }
                isZero = false;
            }finally{
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n / 2; i++) {
            lock.lock();
            try{
                while((turn.get() & 1) != 0) {
                    EVEN_Condition.await();
                }
                printNumber.accept(turn.get());
                // 通知打印0
                isZero = true;
                turn.incrementAndGet();
                ZERO_Condition.signal();
            }finally{
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n - n / 2; i++) {
            lock.lock();
            try{
                while((turn.get() & 1) != 1) {
                    ODD_Condition.await();
                }
                printNumber.accept(turn.get());
                // 通知打印0
                isZero = true;
                turn.incrementAndGet();
                ZERO_Condition.signal();
            }finally{
                lock.unlock();
            }
        }
    }
}
