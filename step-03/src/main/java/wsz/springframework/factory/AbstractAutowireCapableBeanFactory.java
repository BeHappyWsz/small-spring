package wsz.springframework.factory;

import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.strategy.CglibSubclassingInstantiationStrategy;
import wsz.springframework.beans.strategy.InstantiationStrategy;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * bean的生成策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
//    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanNme, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanNme, args);
        } catch (Exception ex) {
            throw new BeansException("Instantiation of bean failed", ex);
        }
        addSingleton(beanNme, bean);
        return bean;
    }

    /**
     * 1.反射获取构造器
     * 2.cglib生成对象
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
