package priv.kimking.base.designpattern.a5singleton.service;

/**
 * 双重锁的方式是方法级锁的优化，减少了部分获取实例的耗时。
 * 线程安全，同时这种方式也满足了懒加载。
 *
 * @author kim
 * @date 2021/12/1
 */
public class DLCFormat {

    private static volatile DLCFormat instance;

    private DLCFormat() {
    }

    public static DLCFormat getInstance(){
       if(null != instance) {
           return instance;
       }
       synchronized (DLCFormat.class){
           if (null == instance){
               instance = new DLCFormat();
           }
       }
       return instance;
    }

}
