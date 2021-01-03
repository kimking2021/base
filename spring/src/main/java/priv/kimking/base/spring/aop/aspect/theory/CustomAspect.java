package priv.kimking.base.spring.aop.aspect.theory;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/4
 */
@Aspect
public class CustomAspect {

    @Pointcut("execution(* priv.kimking.base.spring.aop.aspect.theory.*.*(..))")
    public void custPointcut() {

    }

    @Before("custPointcut()")
    public void beforeCustPointcut() {
        System.out.println("before custom pointcut");
    }
}
