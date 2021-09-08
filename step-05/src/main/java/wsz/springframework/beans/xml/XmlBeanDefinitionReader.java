package wsz.springframework.beans.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import wsz.springframework.beans.config.BeanDefinition;
import wsz.springframework.beans.config.BeanReference;
import wsz.springframework.beans.config.PropertyValue;
import wsz.springframework.beans.reader.AbstractBeanDefinitionReader;
import wsz.springframework.beans.registry.BeanDefinitionRegistry;
import wsz.springframework.core.io.Resource;
import wsz.springframework.core.io.ResourceLoader;
import wsz.springframework.util.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：读取文件，封装并注册BeanDefinition
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream inputStream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 从inputStream中读取并封装、注册BeanDefinition
     * @param inputStream
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (!(item instanceof Element)) continue;
            if (!"bean".equals(item.getNodeName())) continue;

            // 开始解析
            Element bean = (Element) item;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取class
            Class<?> clazz = Class.forName(className);
            // beanName 生成规则
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 属性填充
            NodeList beanChildNodes = bean.getChildNodes();
            for (int j = 0; j < beanChildNodes.getLength(); j++) {
                Node node = beanChildNodes.item(j);
                if (!(node instanceof Element)) continue;
                if (!"property".equals(node.getNodeName())) continue;

                Element property = (Element) node;
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 判断引用
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            // 注册
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
