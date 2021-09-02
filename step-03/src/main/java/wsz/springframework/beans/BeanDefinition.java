package wsz.springframework.beans;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition (Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
