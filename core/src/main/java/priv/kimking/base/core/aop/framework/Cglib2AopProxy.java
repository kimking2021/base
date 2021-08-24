package priv.kimking.base.core.aop.framework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public class Cglib2AopProxy implements AopProxy {

    private final AdviseSupport advise;

    public Cglib2AopProxy(AdviseSupport advise) {
        this.advise = advise;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advise.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advise.getTargetSource().getInterfaces());
        enhancer.setCallback(new CglibMethodInterceptor(advise));
        return enhancer.create();
    }


    private static class CglibMethodInterceptor implements MethodInterceptor {

        private final AdviseSupport advise;

        public CglibMethodInterceptor(AdviseSupport advise) {
            this.advise = advise;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("CglibProxy 代理方法执行");
            CglibMethodInvocation invocation = new CglibMethodInvocation(advise.getTargetSource().getTarget(), method, objects, methodProxy);
            if (advise.getMethodMatcher().matches(method, advise.getTargetSource().getTarget().getClass())) {
                advise.getMethodInterceptor().invoke(invocation);
            }
            return invocation.proceed();
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

        private final MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] arguments, MethodProxy methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return methodProxy.invoke(this.target, this.arguments);
        }
    }

}
