package priv.kimking.base.concurrent;

import priv.kimking.base.concurrent.lock.SyncThis;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/15
 */
public class App {

    public static void main(String... args) throws InterruptedException {
        // System.out.println("hello")/**/;
        SyncThis s = new SyncThis();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // SyncThis s= new SyncThis();
                    s.callSync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread-" + i);
            thread.start();
        }
        Thread.sleep(10000);
    }
}
