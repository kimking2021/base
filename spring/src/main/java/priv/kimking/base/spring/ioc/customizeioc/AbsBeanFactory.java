package priv.kimking.base.spring.ioc.customizeioc;

import java.util.HashMap;

/**
 * <p> 一个抽象类， 实现了 bean 的方法，包含一个map，用于存储bean 的名字和bean的定义
 *
 * @author kim
 * @date 2020/11/23
 */
public abstract class AbsBeanFactory implements CustBeanFactory {

    private HashMap<String, CustBeanDefinition> map = new HashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        CustBeanDefinition beanDefinition = map.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreate(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, CustBeanDefinition beanDefinition) throws Exception {
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name, beanDefinition);
    }

    /**
     * 减少一个bean
     */
    abstract Object doCreate(CustBeanDefinition beanDefinition) throws Exception;
}
