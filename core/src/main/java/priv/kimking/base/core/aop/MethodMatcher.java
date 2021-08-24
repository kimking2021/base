package priv.kimking.base.core.aop;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public interface MethodMatcher {

    /**
     * 判断方法匹配
     * @param method method
     * @param targetClass class
     * @return true or false
     */
    boolean matches(Method method, Class<?> targetClass);
}
