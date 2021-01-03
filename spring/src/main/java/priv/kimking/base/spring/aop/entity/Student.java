package priv.kimking.base.spring.aop.entity;

import priv.kimking.base.spring.aop.entity.Person;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
public class Student implements Person {

    @Override
    public void say() {
        System.out.println("student say invoke...");
    }

}
