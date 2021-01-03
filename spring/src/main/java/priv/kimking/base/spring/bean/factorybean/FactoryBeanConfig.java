package priv.kimking.base.spring.bean.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/28
 */
@Configuration
public class FactoryBeanConfig {

    @Bean
    public StudentFactoryBean studentFactoryBean() {
        return new StudentFactoryBean();
    }

}
