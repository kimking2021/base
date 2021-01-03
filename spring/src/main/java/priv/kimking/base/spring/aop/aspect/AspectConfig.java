package priv.kimking.base.spring.aop.aspect;

import org.springframework.context.annotation.*;
import priv.kimking.base.spring.aop.entity.Student;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
@Configuration
@EnableAspectJAutoProxy
@Import({SayAspect.class})
public class AspectConfig {

    @Bean
    public Student student() {
        return new Student();
    }

}
