package wsz.springframework.beans;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/6
 */
public interface BeanDefintionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
