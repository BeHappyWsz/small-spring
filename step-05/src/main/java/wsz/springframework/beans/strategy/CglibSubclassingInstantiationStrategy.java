package wsz.springframework.beans.strategy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import wsz.springframework.beans.config.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
