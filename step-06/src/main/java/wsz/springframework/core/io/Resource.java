package wsz.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
