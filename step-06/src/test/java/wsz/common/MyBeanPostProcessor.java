package wsz.common;

import wsz.bean.UserService;
import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.config.BeanPostProcessor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/30
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
