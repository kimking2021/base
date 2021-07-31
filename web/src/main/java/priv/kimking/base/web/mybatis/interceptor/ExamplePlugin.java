package priv.kimking.base.web.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.util.Properties;

/**
 * <p> mybatis 拦截器
 *
 * Mybatis拦截器用到责任链模式+动态代理+反射机制；
 *
 * 参考: https://blog.csdn.net/weixin_39494923/article/details/91534658
 *
 * Configuration
 * SqlSessionFactoryBean
 *
 * @author kim
 * @date 2021/7/29
 */
@Slf4j
// @Component
@Intercepts(@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class ExamplePlugin implements Interceptor {

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        log.info("mybatis interceptor pre process");
        Object returnObject = invocation.proceed();
        // implement post processing if need
        log.info("mybatis interceptor post process");
        return returnObject;
    }

}
