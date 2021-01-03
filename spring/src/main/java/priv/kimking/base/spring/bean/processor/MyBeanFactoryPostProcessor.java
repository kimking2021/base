package priv.kimking.base.spring.bean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <p>
 * BeanFactoryPostProcessor主要操作的是bean的元数据: bean的属性，属性的类型，属性的scope等等。
 * @author kim
 * @date 2020/10/28
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor.postProcessBeanFactory()");

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName: beanDefinitionNames) {
            if ("student".equals(beanName)){
                BeanDefinition student = beanFactory.getBeanDefinition(beanName);
                MutablePropertyValues propertyValues = student.getPropertyValues();
                propertyValues.forEach(v -> System.out.println(v.getName() + v.getValue()));
                System.out.println("student scope set");
                // 修改scope
                student.setScope("prototype");
            }
        }
    }

}
