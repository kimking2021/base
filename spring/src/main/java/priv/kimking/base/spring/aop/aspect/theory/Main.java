package priv.kimking.base.spring.aop.aspect.theory;

import org.springframework.aop.framework.ProxyFactory;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/4
 */
public class Main {

    public static void main(String... args) {
        ProxyFactory factory = new ProxyFactory(new Student());
//        factory.addInterface(Person.class);
        factory.addAdvice(new CustomAdvice());
//        factory.addAdvisor();
        Person person = (Person) factory.getProxy();
        person.say();
    }
}
