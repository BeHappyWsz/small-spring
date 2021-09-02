
import org.junit.Test;
import wsz.springframework.beans.BeanDefinition;
import wsz.springframework.factory.DefaultListableBeanFactory;


/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public class SpringTest {

    @Test
    public void cglibBean () {
        String beanNmae = "userService";

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition(beanNmae, new BeanDefinition(UserService.class));
        // 传参
        UserService bean = (UserService) beanFactory.getBean(beanNmae, "wsz");
        System.out.println(bean.toString());
    }
}
