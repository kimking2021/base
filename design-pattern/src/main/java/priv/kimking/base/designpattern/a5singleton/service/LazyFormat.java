package priv.kimking.base.designpattern.a5singleton.service;

/**
 * 懒汉模式(线程不安全)
 *
 * @author kim
 * @date 2021/12/1
 */
public class LazyFormat {

    private static LazyFormat instance;

    private LazyFormat() {
    }

    public static LazyFormat getInstance(){
        if (null != instance) {
            return instance;
        }
        instance = new LazyFormat();
        return instance;
    }

}
