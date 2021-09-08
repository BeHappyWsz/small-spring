package wsz.springframework.beans.reader;

import wsz.springframework.util.BeansException;
import wsz.springframework.beans.registry.BeanDefinitionRegistry;
import wsz.springframework.core.io.Resource;
import wsz.springframework.core.io.ResourceLoader;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
