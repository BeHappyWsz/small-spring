package wsz.springframework.beans.strategy;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：Bean实例化策略
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
