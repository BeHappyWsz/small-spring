package wsz.common;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.PropertyValue;
import wsz.springframework.beans.PropertyValues;
import wsz.springframework.beans.factory.ConfigurableListableBeanFactory;
import wsz.springframework.beans.factory.config.BeanDefinition;
import wsz.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * TODO：修改BeanDefinition
 *
 * @author wsz
 * @desc：
 * @date 2021/9/30
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "111"));
    }
}
