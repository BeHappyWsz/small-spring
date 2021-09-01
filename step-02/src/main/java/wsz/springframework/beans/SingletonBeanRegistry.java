package wsz.springframework.beans;

/**
 * 单例bean注册
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
