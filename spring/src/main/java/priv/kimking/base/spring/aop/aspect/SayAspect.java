package priv.kimking.base.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import priv.kimking.base.spring.aop.aspect.AopCustomException;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
@Aspect
@Component
public class SayAspect {

    @Pointcut("execution(* *.say(..))")
    public void test(){}

    @Before("test()")
    public void before(){
        System.out.println("before test..");
    }

    @After("test()")
    public void after(){
        System.out.println("after test..");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

    @AfterThrowing(pointcut = "test()", throwing = "ex")
    public void afterThrowing(AopCustomException ex) {
        System.out.println("exception: " + ex.getLocalizedMessage());
    }

}
