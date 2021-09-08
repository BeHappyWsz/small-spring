package wsz.springframework.beans.config;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/7
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
