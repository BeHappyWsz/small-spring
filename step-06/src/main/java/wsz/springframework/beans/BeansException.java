package wsz.springframework.beans;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
