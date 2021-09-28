package wsz.springframework.beans.factory.config;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
