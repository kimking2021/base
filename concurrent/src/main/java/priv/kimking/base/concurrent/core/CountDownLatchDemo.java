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
public class CountDownLatchDemo {

    private static final Logger log = LoggerFactory.getLogger(CountDownLatchDemo.class);

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        log.info("主线程开始执行");
        // 1st sub thread
        ExecutorService esF = Executors.newSingleThreadExecutor();
        esF.execute(() -> {
            try {
                Thread.sleep(300);
                log.info("Sub thread execute: {}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        esF.shutdown();

        // 2nd sub thread
        ExecutorService esS = Executors.newSingleThreadExecutor();
        esS.execute(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Sub thread execute: {}", Thread.currentThread().getName());
            latch.countDown();
        });
        esS.shutdown();
        log.info("Waiting 2 thread execute done....");
        try {
            // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("2 thread all done, execute main thread ");
    }

}
