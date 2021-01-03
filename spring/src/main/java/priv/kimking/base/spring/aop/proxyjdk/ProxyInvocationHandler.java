package priv.kimking.base.spring.aop.proxyjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/30
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private final Object target;

    ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("execute before target method::"+method.getName()+" invoke...");
        Object result = method.invoke(target, args);
        System.out.println("execute before target method::"+method.getName()+" invoked...");
        return result;
    }
}
