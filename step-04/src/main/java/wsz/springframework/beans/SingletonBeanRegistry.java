package wsz.springframework.beans;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
