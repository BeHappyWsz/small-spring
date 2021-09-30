package wsz.springframework.context.support;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.ConfigurableListableBeanFactory;
import wsz.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public abstract class AbstractRefreshableApplictionContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
}
