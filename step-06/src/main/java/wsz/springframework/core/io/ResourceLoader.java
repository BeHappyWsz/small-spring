package wsz.springframework.core.io;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
