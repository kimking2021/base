package priv.kimking.base.core.aop.framework;

import org.aopalliance.intercept.MethodInvocation;
import priv.kimking.base.core.aop.MethodMatcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdviseSupport advise;


    public JdkDynamicAopProxy(AdviseSupport advise) {
        this.advise = advise;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK代理方法执行");
        if (advise.getMethodMatcher().matches(method, advise.getTargetSource().getTarget().getClass())) {
            MethodInvocation invocation = new ReflectiveMethodInvocation(advise.getTargetSource().getTarget(), method, args);
            return advise.getMethodInterceptor().invoke(invocation);
        }
        return method.invoke(advise.getTargetSource().getTarget(), args);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), advise.getTargetSource().getInterfaces(), this);
    }

}
