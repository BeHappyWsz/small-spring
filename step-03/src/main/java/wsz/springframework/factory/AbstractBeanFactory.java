package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.DefaultSingletonBeanRegistry;
import wsz.springframework.util.BeansException;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 模板：有参构造
     * @param beanNme
     * @param beanDefinition
     * @param args
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanNme, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
