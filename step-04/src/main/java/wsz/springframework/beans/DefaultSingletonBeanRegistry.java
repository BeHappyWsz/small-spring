package wsz.springframework.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object bean) {
        singletonObjects.put(beanName, bean);
    }

}
