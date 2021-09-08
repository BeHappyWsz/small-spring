package wsz.springframework.beans.factory;

import wsz.springframework.beans.config.BeanDefinition;
import wsz.springframework.util.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
