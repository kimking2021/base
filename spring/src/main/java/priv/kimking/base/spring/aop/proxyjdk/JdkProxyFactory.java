package priv.kimking.base.spring.aop.proxyjdk;

import priv.kimking.base.spring.aop.proxyjdk.ProxyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/30
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyInvocationHandler(target)
        );
    }

}
