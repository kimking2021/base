import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.kimking.base.spring.aop.aspect.AspectConfig;
import priv.kimking.base.spring.aop.proxyjdk.JdkProxyFactory;
import priv.kimking.base.spring.aop.entity.Person;
import priv.kimking.base.spring.aop.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
public class AopTest {

    @Test
    public void testJdkDynamicProxy() {
        Student student = new Student();
        Person person = (Person) JdkProxyFactory.getProxy(student);
        person.say();
    }

    @Test
    public void testBasic() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectConfig.class);
        Person student = (Person) applicationContext.getBean("student");
        student.say();
    }

}
