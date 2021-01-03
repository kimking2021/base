import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.kimking.base.spring.bean.config.BeanConfig;
import priv.kimking.base.spring.bean.config.LazyConfig;
import priv.kimking.base.spring.bean.config.ProxyBeanMethodConfig;
import priv.kimking.base.spring.bean.entity.Book;
import priv.kimking.base.spring.bean.entity.Student;
import priv.kimking.base.spring.bean.beanlifecycle.LifeCycleBean;
import priv.kimking.base.spring.bean.beanlifecycle.LifeCycleConfig;
import priv.kimking.base.spring.bean.factorybean.FactoryBeanConfig;
import priv.kimking.base.spring.bean.processor.BeanFactoryPostProcessorConfig;
import priv.kimking.base.spring.bean.processor.BeanPostProcessorConfig;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
public class BeanTest {


    /**
     * bean的配置与获取
     */
    @Test
    public void testGetBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        Book book = (Book) applicationContext.getBean("book");
        System.out.println(book);
        applicationContext.close();
    }

    /**
     * bean生命周期
     */
    @Test
    public void testBeanLifeCycle() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("application started...");
        LifeCycleBean lifeCycleBean = (LifeCycleBean) applicationContext.getBean("lifeCycleBean");
        applicationContext.close();
    }

    @Test
    public void testBeanPostProcessor() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
        System.out.println("application started");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        applicationContext.close();
    }

    @Test
    public void testBeanFactoryPostProcessor() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
        System.out.println("application started");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
        applicationContext.close();
    }

    @Test
    public void testFactoryBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        System.out.println("application started");
        Student student = (Student) applicationContext.getBean("studentFactoryBean");
        System.out.println(student);
        applicationContext.close();
    }

    @Test
    public void testProxyBeanMethod() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyBeanMethodConfig.class);
        Book book1 = (Book) context.getBean("book");
        System.out.println(book1);
        Book book2 = (Book) context.getBean("book");
        System.out.println(book2);
    }

    @Test
    public void testLazyBean() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LazyConfig.class);
        System.out.println("application started");
        System.out.println(context.getBean("student").getClass().getName());
    }


}
