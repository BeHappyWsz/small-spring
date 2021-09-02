/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/1
 */
public class UserService {
    private String name;

    public UserService() {
    }
    public UserService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("aaaaa");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
