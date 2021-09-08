package wsz.springframework.beans.reader;

import wsz.springframework.beans.registry.BeanDefinitionRegistry;
import wsz.springframework.core.io.DefaultResourceLoader;
import wsz.springframework.core.io.ResourceLoader;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
