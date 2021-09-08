package wsz.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * TODO：
 *  远程获取资源
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException ex) {
            // 关闭链接
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }
}
