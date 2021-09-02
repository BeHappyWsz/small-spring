package wsz.springframework.factory;

import wsz.springframework.util.BeansException;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
