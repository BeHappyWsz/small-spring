package wsz.springframework.beans.factory.config;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * TODO：自定义
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
