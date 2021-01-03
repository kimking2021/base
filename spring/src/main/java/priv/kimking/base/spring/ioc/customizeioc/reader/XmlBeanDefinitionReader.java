package priv.kimking.base.spring.ioc.customizeioc.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import priv.kimking.base.spring.ioc.customizeioc.*;
import priv.kimking.base.spring.ioc.customizeioc.property.CustBeanReference;
import priv.kimking.base.spring.ioc.customizeioc.property.CustPropertyValue;
import priv.kimking.base.spring.ioc.customizeioc.resource.CustResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public class XmlBeanDefinitionReader extends AbsCustBeanDefinitionReader {

    /**
     * 构造器，必须包含一个资源加载器
     */
    public XmlBeanDefinitionReader(CustResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    /**
     *
     * @param location
     * @throws Exception
     */
    public void readXml(String location) throws Exception {
        CustResourceLoader resourceLoader = new CustResourceLoader();
        InputStream inputStream = resourceLoader.getResource(location).getInputStream();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String classname = ele.getAttribute("class");
        CustBeanDefinition beanDefinition = new CustBeanDefinition();
        beanDefinition.setClassname(classname);
        addPropertyValues(ele, beanDefinition);
        getRegistry().put(name, beanDefinition);
    }

    private void addPropertyValues(Element ele, CustBeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new CustPropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException(
                                "Configuration problem: <property> element for property '"
                                        + name + "' must specify a ref or value");
                    }
                    CustBeanReference beanRef = new CustBeanReference(name);
                    beanDefinition.getPropertyValues().addPropertyValue(new CustPropertyValue(name, beanRef));
                }
            }
        }
    }

}
