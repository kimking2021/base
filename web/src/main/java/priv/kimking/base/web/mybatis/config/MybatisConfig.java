package priv.kimking.base.web.mybatis.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.kimking.base.web.mybatis.interceptor.ExamplePlugin;

/**
 * <p>
 *
 * @author kim
 * @date 2021/7/31
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.addInterceptor(new ExamplePlugin());
            }
        };
    }
}
