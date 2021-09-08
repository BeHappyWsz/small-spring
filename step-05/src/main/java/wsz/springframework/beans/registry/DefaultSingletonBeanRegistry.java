package wsz.springframework.beans.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/8
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
