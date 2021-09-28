package wsz.springframework.beans.factory;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.config.AutowireCapableBeanFactory;
import wsz.springframework.beans.factory.config.BeanDefinition;
import wsz.springframework.beans.factory.config.BeanPostProcessor;
import wsz.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
