package wsz.springframework.beans.factory;

import wsz.springframework.beans.factory.HierarchicalBeanFactory;
import wsz.springframework.beans.registry.SingletonBeanRegistry;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
