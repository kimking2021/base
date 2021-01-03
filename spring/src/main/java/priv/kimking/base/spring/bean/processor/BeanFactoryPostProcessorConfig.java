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
public class BeanFactoryPostProcessorConfig {

    @Bean
    public Student student() {
        return new Student(11, "kim", 22);
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }

}
