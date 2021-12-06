package priv.kimking.base.designpattern.a5singleton.service;

/**
 * 懒汉模式(线程安全)
 * 但由于把锁加到方法上后，所有的访问都因需要锁占用导致资源的浪费。
 *
 * @author kim
 * @date 2021/12/1
 */
public class SecurityLazyFormat {

    private static SecurityLazyFormat instance;

    private SecurityLazyFormat() {
    }

    public static synchronized SecurityLazyFormat getInstance(){
        if (null != instance) {
            return instance;
        }
        instance = new SecurityLazyFormat();
        return instance;
    }

}
