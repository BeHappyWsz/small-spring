package wsz.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO 注册&获取bean
 * @author wsz
 * @desc:
 * @date 2021/9/1
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new RuntimeException("getBean Null");
        }
        return beanDefinition.getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
