import org.junit.Test;
import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.factory.DefaultListableBeanFactory;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public class SpringTest {

    @Test
    public void test () {
        String beanNmae = "userService";
        // UserService需要提供无参构造
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition(beanNmae, new BeanDefinition(UserService.class));

        UserService bean = (UserService) beanFactory.getBean(beanNmae);
        System.out.println(bean.toString());

        UserService singleton = (UserService) beanFactory.getSingleton(beanNmae);
        System.out.println(singleton.toString());
    }
}
