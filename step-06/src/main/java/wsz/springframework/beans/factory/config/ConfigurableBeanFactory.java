package wsz.springframework.beans.factory.config;

import wsz.springframework.beans.factory.HierarchcalBeanFactory;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public interface ConfigurableBeanFactory  extends HierarchcalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
