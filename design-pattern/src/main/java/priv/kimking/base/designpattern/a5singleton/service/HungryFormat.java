package priv.kimking.base.designpattern.a5singleton.service;

/**
 * 饿汉模式(线程安全)
 *
 * 内存占用大
 *
 * @author kim
 * @date 2021/12/1
 */
public class HungryFormat {

    private static HungryFormat instance = new HungryFormat();

    private HungryFormat() {
    }

    public static HungryFormat getInstance() {
        return instance;
    }

}
