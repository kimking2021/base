package priv.kimking.base.concurrent.lock;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/15
 */
public class SyncThis {

    private synchronized void method() throws InterruptedException {
        System.out.println("sync method call");
        Thread.sleep(3000);
        anmethod();
    }

    private synchronized void anmethod() throws InterruptedException {
        System.out.println("another sync method call");
        Thread.sleep(1000);
    }

    public void callSync() throws InterruptedException {
        method();
    }

}
