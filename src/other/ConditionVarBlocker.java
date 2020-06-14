package other;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVarBlocker implements Blocker{
    private final Lock lock;
    private final Condition condition;

    public ConditionVarBlocker (Lock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public ConditionVarBlocker () {
        /*
        * 可重入锁是指就是一个线程在获取了锁之后，再次去获取了同一个锁，这时候仅仅是把状态值进行累加
        * */
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }

    @Override
    public <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception {
        // 加锁
        lock.lockInterruptibly();
        V result;
        try{
            final Predicate guard = guardedAction.guard;
            // 前置条件不成立，线程就一直处于等待状态。
            // 调用await方法后，线程就释放锁。直到等到其他协作线程的通知，才会重新竞争锁
            // 在竞争到锁之后，就从await之后的地方开始执行代码。
            while(!guard.evaluate()) {
                condition.await();
            }
            // 前置条件成立后，执行具体的动作
            result = guardedAction.call();
            return result;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void signalAfter(Callable<Boolean> stateOperation) throws Exception {
        lock.lockInterruptibly();
        try{
            if (stateOperation.call()) {
                condition.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void signal() throws InterruptedException {
        lock.lockInterruptibly();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void broadcastAfter(Callable<Boolean> stateOperation) throws Exception {
        lock.lockInterruptibly();
        try{
            condition.notifyAll();
        }finally {
            lock.unlock();
        }
    }
}
