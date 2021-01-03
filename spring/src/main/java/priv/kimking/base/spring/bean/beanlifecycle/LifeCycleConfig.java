package priv.kimking.base.spring.bean.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
@Configuration
public class LifeCycleConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifeCycleBean lifeCycleBean() {
        return new LifeCycleBean();
    }
}
