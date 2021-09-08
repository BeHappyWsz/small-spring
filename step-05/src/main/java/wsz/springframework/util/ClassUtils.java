package wsz.springframework.util;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader () {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
