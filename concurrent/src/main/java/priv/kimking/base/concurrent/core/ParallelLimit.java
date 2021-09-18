package priv.kimking.base.concurrent.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/18
 */
public class ParallelLimit {
    private static final Logger log = LoggerFactory.getLogger(ParallelLimit.class);

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(latch);
            es.execute(runnable);
        }
        log.info("Main thread execute");
    }


    static class CountRunnable implements Runnable {

        private final CountDownLatch latch;

        public CountRunnable(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                synchronized (latch) {
                    latch.countDown();
                    log.info("thread count: {}", latch.getCount());
                }
                latch.await();
                log.info("concurrent count: {}", 100-latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
