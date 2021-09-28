package wsz.springframework.beans.factory.config;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.BeanFactory;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
