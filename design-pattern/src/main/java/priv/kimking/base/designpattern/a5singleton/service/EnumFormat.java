package priv.kimking.base.designpattern.a5singleton.service;

/**
 * 枚举单例(线程安全）
 *
 * 这种方式解决了最主要的；线程安全、自由串行化、单一实例。
 * 无偿地提供了串行化机制，绝对防止对此实例化，即使是在面对复杂的串行化或者反射攻击的时候
 *
 * 此种方式在存在继承场景下是不可用的
 *
 * @author kim
 * @date 2021/12/1
 */
public enum EnumFormat {

    /**
     *
     */
    INSTANCE;

}
