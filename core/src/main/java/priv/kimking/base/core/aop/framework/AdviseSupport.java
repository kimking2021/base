package priv.kimking.base.core.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import priv.kimking.base.core.aop.MethodMatcher;
import priv.kimking.base.core.aop.TargetSource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public class AdviseSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    public AdviseSupport() {
    }

    public AdviseSupport(TargetSource target, MethodInterceptor methodInterceptor, MethodMatcher methodMatcher) {
        this.targetSource = target;
        this.methodInterceptor = methodInterceptor;
        this.methodMatcher = methodMatcher;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource target) {
        this.targetSource = target;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
