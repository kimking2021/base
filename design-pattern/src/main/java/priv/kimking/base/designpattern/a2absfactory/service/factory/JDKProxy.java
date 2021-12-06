package priv.kimking.base.designpattern.a2absfactory.service.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 缓存抽象工厂-代理类
 *
 * @author kim
 * @date 2021/12/1
 */
public class JDKProxy {

    /**
     * 根据不同的缓存适配类型，返回相应的工厂类
     */
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

}
