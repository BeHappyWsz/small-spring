package wsz.springframework.context.support;

import wsz.springframework.beans.factory.support.DefaultListableBeanFactory;
import wsz.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplictionContext {

    protected abstract String[] getConfigLocations();

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            definitionReader.loadBeanDefinitions(configLocations);
        }
    }
}
