package priv.kimking.base.spring.aop.aspect.theory;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/4
 */
public class MainAspectJ {

    public static void main(String... args) {
        AspectJProxyFactory factory = new AspectJProxyFactory(new Student());
        factory.addAspect(new CustomAspect());
        Person person = factory.getProxy();
        person.say();
    }
}
