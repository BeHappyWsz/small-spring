package wsz.springframework.factory;

import cn.hutool.core.bean.BeanUtil;
import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.property.BeanReference;
import wsz.springframework.beans.property.PropertyValue;
import wsz.springframework.beans.property.PropertyValues;
import wsz.springframework.beans.strategy.CglibInstantiationStrategy;
import wsz.springframework.beans.strategy.InstantionStrategy;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory{

    private InstantionStrategy instantionStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception ex) {
            throw new BeansException("Insantitation of bean failed", ex);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * bean属性填充
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue: propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // 暂时不处理循环依赖
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // hutool属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception ex) {
            throw new BeansException("error setting property values: " + beanName);
        }
    }

    /**
     * cglib创建bean实例
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 目前只用数量判断
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantionStrategy().instantiate(beanDefinition, beanName, constructor,args);
    }

    public InstantionStrategy getInstantionStrategy() {
        return instantionStrategy;
    }

    public void setInstantionStrategy(InstantionStrategy instantionStrategy) {
        this.instantionStrategy = instantionStrategy;
    }
}
