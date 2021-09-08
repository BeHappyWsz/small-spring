package wsz.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO：
 *  资源加载器：File
 * @author wsz
 * @desc：
 * @date 2021/9/7
 */
public class FileSystemResource implements Resource {

    private File file;
    private String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    public String getPath() {
        return path;
    }
}
