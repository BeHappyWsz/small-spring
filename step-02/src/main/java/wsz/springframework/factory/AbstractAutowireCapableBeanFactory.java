package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            // 直接newInstance需要提供无参构造
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new BeansException("Instantiation of bean failed", ex);
        }
        // 实例化成功，存到单例中
        addSingleton(beanName, bean);
        return bean;
    }
}
