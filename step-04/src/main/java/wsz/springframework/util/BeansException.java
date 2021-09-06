package wsz.springframework.util;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/2
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
