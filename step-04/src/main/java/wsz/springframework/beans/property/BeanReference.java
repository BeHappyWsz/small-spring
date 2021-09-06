package wsz.springframework.beans.property;

/**
 * TODO：bean引用
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
