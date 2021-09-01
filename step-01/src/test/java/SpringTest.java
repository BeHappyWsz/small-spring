import org.junit.Test;
import wsz.springframework.BeanDefinition;
import wsz.springframework.BeanFactory;

/**
 * @author wsz
 * @desc:
 * @date 2021/9/1
 */
public class SpringTest {

    @Test
    public void test() {
        BeanDefinition beanDefinition = new BeanDefinition(new UserService("wsz"));

        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.toString());
    }
}
