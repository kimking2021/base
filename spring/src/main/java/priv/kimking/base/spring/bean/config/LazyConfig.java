package priv.kimking.base.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import priv.kimking.base.spring.bean.entity.Book;
import priv.kimking.base.spring.bean.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/27
 */
@Configuration
public class LazyConfig {

    @Lazy
    @Bean
    public Book book() {
        return new Book();
    }

}
