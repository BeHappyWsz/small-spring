package wsz.springframework.beans.strategy;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public interface InstantionStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
