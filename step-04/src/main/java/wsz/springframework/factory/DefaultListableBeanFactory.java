package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.BeanDefintionRegistry;
import wsz.springframework.util.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public class DefaultListableBeanFactory extends AbstractAutowiredCapableBeanFactory implements BeanDefintionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }
}
