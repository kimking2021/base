package priv.kimking.base.core.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p> JDK动态代理
 *
 * @author kim
 * @date 2021/7/29
 */
public class TargetProxy implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public TargetProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // preHandle
        System.out.println("pre-handle");

        Object result = method.invoke(target, args);

        // postHandle
        System.out.println("post-handle");
        return result;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        Target target = new Target();
        TargetProxy targetProxy = new TargetProxy(target);

        ProxyUtils.generateClassFile(target.getClass(), "TargetProxyS");

        // ITarget proxy = (ITarget) targetProxy.createProxy();
        // System.out.println(proxy.getClass().getName());
        // proxy.say();

    }

}
