package Main;

public class User {
    private String Name;
    private String Password;
    private int Count;

    public User() {
    }

    public User(String Name, String Password, int Count) {
        this.Name = Name;
        this.Password = Password;
        this.Count = Count;
    }

    /**
     * 获取
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 设置
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 获取
     * @return Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * 设置
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * 获取
     * @return Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 设置
     * @param Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    public String toString() {
        return "Name =" + Name + "&Password=" + Password + "&Count=" + Count;
    }
}
