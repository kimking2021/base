package priv.kimking.base.spring.ioc.customizeioc;

import priv.kimking.base.spring.ioc.customizeioc.property.CustPropertyValues;

/**
 * <p> bean 的定义
 *
 * @author kim
 * @date 2020/11/23
 */
public class CustBeanDefinition {

    /**
     * bean
     */
    private Object bean;

    /**
     * bean 的 Class 对象
     */
    private Class beanClass;

    /**
     * bean 的类全限定名称
     */
    private String classname;

    /**
     * 类的属性集合
     */
    private CustPropertyValues propertyValues = new CustPropertyValues();


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    /**
     * 获取bean的Class对象
     */
    public Class getBeanClass() {
        return beanClass;
    }

    /**
     * 通过设置类名称反射生成Class对象
     * @param classname
     */
    public void setClassname(String classname) {
        this.classname = classname;
        try {
            this.beanClass = Class.forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CustPropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(CustPropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
