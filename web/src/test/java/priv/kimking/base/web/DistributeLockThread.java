package priv.kimking.base.web;

import lombok.extern.slf4j.Slf4j;
import priv.kimking.base.web.provider.RedissonProvider;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/19
 */
@Slf4j
public class DistributeLockThread extends Thread {


    private static final String LOCK_KEY = "lockKey";

    private final RedissonProvider redissonProvider;


    public DistributeLockThread(RedissonProvider redissonProvider) {
        super();
        this.redissonProvider = redissonProvider;
    }

    @Override
    public void run() {
        // for (int i = 0; i < 5; i++) {
        //     log.info("{}运行  :  {}", name,  i);
        //     try {
        //         sleep((int) Math.random() * 10);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
        try {
            log.info("线程执行：{}", Thread.currentThread().getName());
            redissonProvider.demoDistributeLockByRedis(LOCK_KEY);
        } catch (InterruptedException e) {
            log.info("中断异常");
        }
    }

    public static void main(String[] args) {
        // Thread threadFoo = new DistributeLockThread("Foo");
        // Thread threadBar = new DistributeLockThread("Bar");
        // threadFoo.start();
        // threadBar.start();
    }

}
