package wsz.springframework.beans.strategy;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO：原生生成对象
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (null != constructor) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
