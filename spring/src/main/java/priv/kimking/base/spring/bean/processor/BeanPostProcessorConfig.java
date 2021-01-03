package priv.kimking.base.spring.bean.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.kimking.base.spring.bean.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
@Configuration
public class BeanPostProcessorConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Student student() {
        return new Student(11, "kim", 22);
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
