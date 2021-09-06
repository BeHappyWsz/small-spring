package wsz.springframework.factory;

import wsz.springframework.util.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

}
