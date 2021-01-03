package priv.kimking.base.spring.bean.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
public class LifeCycleBean implements Serializable, InitializingBean, DisposableBean {

    private static final long serialVersionUID = 2731651017595722776L;

    public LifeCycleBean() {
        System.out.println("LifeCycle constructor invoke...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("post-constructor invoke...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init...");
    }

    public void initMethod() {
        System.out.println("LifeCycle initMethod invoke...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("pre-destroy invoke...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy...");
    }

    public void destroyMethod() {
        System.out.println("LifeCycle destroyMethod invoke...");
    }

}
