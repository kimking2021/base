package priv.kimking.base.designpattern.a5singleton.service;

/**
 *
 * 使用类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的方式耗费性能。
 * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是一个类的构造方法在多线程环境下可以被正确的加载。
 * 此种方式也是非常推荐使用的一种单例模式
 *
 * 内部类：内部类是延时加载的，也就是说只会在第一次使用时加载。不使用就不加载。
 *
 * @author kim
 * @date 2021/12/1
 */
public class InnerClassFormat {


    // 内部类：内部类是延时加载的，也就是说只会在第一次使用时加载。不使用就不加载。
    private static class SingletonHolder {
        private static InnerClassFormat instance = new InnerClassFormat();
    }

    private InnerClassFormat() {
        System.out.println("InnerClassFormat initial");
    }

    public static InnerClassFormat getInstance() {
        System.out.println("getInstance called");
        return SingletonHolder.instance;
    }

}
