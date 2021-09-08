package wsz.springframework.beans.strategy;

import wsz.springframework.util.BeansException;
import wsz.springframework.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
