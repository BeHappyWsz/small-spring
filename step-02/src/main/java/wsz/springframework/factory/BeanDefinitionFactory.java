package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;

public interface BeanDefinitionFactory {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
