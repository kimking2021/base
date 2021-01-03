package priv.kimking.base.spring.aop.aspect.theory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/4
 */
public class CustomAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method m, Object[] args, Object target) throws Throwable {
        System.out.println("method before advice...");
    }
}
