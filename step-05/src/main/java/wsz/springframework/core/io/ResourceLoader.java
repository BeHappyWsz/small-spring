package wsz.springframework.core.io;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
