package wsz.springframework;

/**
 * TODO 定义bean的信息
 * @author wsz
 * @desc:
 * @date 2021/9/1
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition (Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
