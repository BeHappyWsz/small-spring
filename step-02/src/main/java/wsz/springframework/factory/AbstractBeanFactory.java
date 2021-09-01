package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.DefaultSingletonBeanRegistry;
import wsz.springframework.util.BeansException;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // BeanDefinition -> Bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

}
