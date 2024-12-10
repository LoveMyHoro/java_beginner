package t9_io流.j6_综合练习.练习_4_登陆注册;

public class User {
    private String username;
    private String password;
    private int count;

    public User() {
    }

    public User(String username, String password, int count) {
        this.username = username;
        this.password = password;
        this.count = count;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return "username=" + username + "&password=" + password + "&count=" + count;
    }
}
