package priv.kimking.base.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import priv.kimking.base.spring.bean.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
@Configuration
public class StudentConfig {

    @Bean(name = "student")
    @Scope(value = "singleton")
    public Student student() {
        return new Student(11, "kim", 22);
    }


}
