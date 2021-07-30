package priv.kimking.base.core.proxy;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/29
 */
public class Target implements ITarget {


    @Override
    public void say() {
        System.out.println("target say");
    }

    public void fly() {
        System.out.println("target fly");
    }

}
