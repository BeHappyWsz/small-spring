import org.junit.Test;
import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.beans.property.BeanReference;
import wsz.springframework.beans.property.PropertyValue;
import wsz.springframework.beans.property.PropertyValues;
import wsz.springframework.factory.DefaultListableBeanFactory;

/**
 * TODO：属性填充，暂时不处理循环依赖
 *  1.BeanDefinition，补充变量；
 *  2.BeanReference，标识引用变量
 *  3.AbstractAutowiredCapableBeanFactory，cglib创建bean实例后，进行属性变量填充。
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public class SpringTests {

    @Test
    public void tt() {
        // 1.beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册dao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3.属性
        PropertyValues propertyValues = new PropertyValues()
                .addPropertyValue(new PropertyValue("uId", "10001"))
                .addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // 4.注入service
        beanFactory.registerBeanDefinition("userService",
                new BeanDefinition(UserService.class, propertyValues));

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
