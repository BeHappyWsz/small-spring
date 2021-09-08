package wsz.springframework.beans.registry;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
