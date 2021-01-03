package priv.kimking.base.spring.ioc.customizeioc.reader;

import priv.kimking.base.spring.ioc.customizeioc.CustBeanDefinition;
import priv.kimking.base.spring.ioc.customizeioc.resource.CustResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public abstract class AbsCustBeanDefinitionReader implements CustBeanDefinitionReader {


    /**
     * 注册bean容器
     */
    private CustResourceLoader resourceLoader;

    /**
     * 资源加载器
     */
    private Map<String, CustBeanDefinition> registry;

    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     * @param resourceLoader 资源加载器
     */
    protected AbsCustBeanDefinitionReader(CustResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取容器
     */
    public Map<String, CustBeanDefinition> getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     */
    public CustResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
