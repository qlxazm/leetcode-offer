package other;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;

import java.util.concurrent.*;

/**
 * @author yd
 * @date 2020/4/4 20:27
 */
public class ThreadPooTest {

    public static void main(String[] args) {
       ExecutorService threadPool = new ThreadPoolExecutor(5, 10,
               10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
               new ThreadFactory() {
                   @Override
                   public Thread newThread(Runnable r) {
                       Thread t = new Thread(r);
                       t.setUncaughtExceptionHandler((t1, e) -> {
                           System.out.println(t1.getName() + e);
                       });
                       return t;
                   }
               });

        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                Object o = null;
                System.out.println(o.toString());
            });
        }
        threadPool.shutdown();
    }
}
