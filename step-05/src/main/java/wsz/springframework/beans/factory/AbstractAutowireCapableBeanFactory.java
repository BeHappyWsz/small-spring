package wsz.springframework.beans.factory;

import cn.hutool.core.bean.BeanUtil;
import wsz.springframework.util.BeansException;
import wsz.springframework.beans.config.PropertyValue;
import wsz.springframework.beans.config.PropertyValues;
import wsz.springframework.beans.config.BeanDefinition;
import wsz.springframework.beans.config.BeanReference;
import wsz.springframework.beans.strategy.CglibSubclassingInstantiationStrategy;
import wsz.springframework.beans.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * TODO：
 * 1.cglib实例化bean
 * 2.bean属性填充
 * 3.bean进容器
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // bean实例化
            bean = creteBeanInstance(beanDefinition, beanName, args);
            // 属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception ex) {
            throw new BeansException("Instantiation of bean failed", ex);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * bean实例化：
     * 1.目前根据构造器的数量判断
     * 2.构造器找不到使用无参构造
     * @param beanDefinition
     * @param beanName
     * @param args
     */
    protected Object creteBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for(Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    /**
     * 属性填充
     * 1.目前不处理循环依赖
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue: propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                // 暂不考虑循环依赖
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
