package priv.kimking.base.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import priv.kimking.base.spring.bean.entity.Book;
import priv.kimking.base.spring.bean.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
@Configuration
@Import(value = StudentConfig.class)
public class BeanConfig {

    @Bean
    public Book book() {
        return new Book();
    }

}
