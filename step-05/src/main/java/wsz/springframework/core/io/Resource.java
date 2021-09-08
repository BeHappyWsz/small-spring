package wsz.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：资源管理接口-3种实现
 *
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
