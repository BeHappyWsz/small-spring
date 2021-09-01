package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
