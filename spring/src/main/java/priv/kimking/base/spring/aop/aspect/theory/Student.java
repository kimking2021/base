package priv.kimking.base.spring.aop.aspect.theory;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/4
 */
public class Student implements Person {

    @Override
    public void say() {
        System.out.println("student say invoke...");
    }
}
