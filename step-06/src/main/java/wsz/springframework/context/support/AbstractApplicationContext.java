package wsz.springframework.context.support;

import wsz.springframework.beans.BeansException;
import wsz.springframework.beans.factory.ConfigurableListableBeanFactory;
import wsz.springframework.beans.factory.config.BeanFactoryPostProcessor;
import wsz.springframework.beans.factory.config.BeanPostProcessor;
import wsz.springframework.context.ConfigurationApplicationContext;
import wsz.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/27
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurationApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory，加载BeanDefinition
        refreshBeanFactory();
        // 2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3.在Bean实例化之前，执行
        invokeBeanFactoryPostProcessors(beanFactory);
        // 4.BeanPostProcessor需要提前与其他Bean对象实例化之前注册操作
        registerBeanPostProcessors(beanFactory);
        // 5.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> postProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor processor : postProcessorMap.values()) {
            processor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> postProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for(BeanPostProcessor processor : postProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(processor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }
}
