package wsz.springframework.factory;

import wsz.springframework.util.BeansException;

/**
 * TODO：BeanDefinition -> Bean
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
