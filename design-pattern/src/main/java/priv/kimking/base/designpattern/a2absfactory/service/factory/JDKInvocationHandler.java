package priv.kimking.base.designpattern.a2absfactory.service.factory;

import priv.kimking.base.designpattern.a2absfactory.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kim
 * @date 2021/12/1
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }

}
