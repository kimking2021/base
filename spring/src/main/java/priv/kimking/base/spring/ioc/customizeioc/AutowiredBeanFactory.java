package priv.kimking.base.spring.ioc.customizeioc;

import priv.kimking.base.spring.ioc.customizeioc.property.CustBeanReference;
import priv.kimking.base.spring.ioc.customizeioc.property.CustPropertyValue;

import java.lang.reflect.Field;

/**
 * <p> 实现自动注入和递归注入(spring 的标准实现类 DefaultListableBeanFactory 有 1810 行)
 *
 * @author kim
 * @date 2020/11/23
 */
public class AutowiredBeanFactory extends AbsBeanFactory {

    /**
     * 根据bean 定义创建实例， 并将实例作为key， bean定义作为value存放，并调用 addPropertyValue 方法 为给定的bean的属性进行注入
     */
    @Override
    protected Object doCreate(CustBeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        addPropertyValue(bean, beanDefinition);
        return bean;
    }

    /**
     * 给定一个bean定义和一个bean实例，为给定的bean中的属性注入实例。
     */
    protected void addPropertyValue(Object bean, CustBeanDefinition beanDefinition) throws Exception {
        for (CustPropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
            // 根据给定属性名称获取 给定的bean中的属性对象
            Field declaredField = bean.getClass().getDeclaredField(pv.getName());
            Object value = pv.getVaule();
            if (value instanceof CustBeanReference) {
                CustBeanReference beanRef = (CustBeanReference) value;
                // 调用父类的 AbstractBeanFactory 的 getBean 方法，根据bean引用的名称获取实例，此处即是递归
                value = getBean(beanRef.getName());
            }
            declaredField.set(bean, value);
        }
    }


}
