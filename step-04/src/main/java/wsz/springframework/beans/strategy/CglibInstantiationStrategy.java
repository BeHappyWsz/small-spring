package wsz.springframework.beans.strategy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.util.BeansException;

import java.lang.reflect.Constructor;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public class CglibInstantiationStrategy implements InstantionStrategy{
    /**
     *
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
