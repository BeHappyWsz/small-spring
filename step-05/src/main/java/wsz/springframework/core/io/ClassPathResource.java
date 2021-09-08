package wsz.springframework.core.io;

import cn.hutool.core.lang.Assert;
import wsz.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：
 *  资源加载：classLoader
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public class ClassPathResource implements Resource{

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be oppend because it does not exist");
        }
        return is;
    }
}
