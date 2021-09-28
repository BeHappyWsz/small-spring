package wsz.springframework.beans.factory.support;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
