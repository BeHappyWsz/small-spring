package wsz.springframework.core.io;

import cn.hutool.core.lang.Assert;
import wsz.springframework.uti.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/24
 */
public class ClassPathResource implements Resource {
    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream == null) {
            throw new FileNotFoundException(this.path + "cannot be open because it does not exist");
        }
        return stream;
    }
}
