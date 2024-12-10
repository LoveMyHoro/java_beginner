package t6_方法引用;

public class Student {
    private String name;
    private int age;

    public Student() {
    }
    //为了引用构造方法
    public Student(String s){
        String name=s.split(",")[0];
        int age=Integer.parseInt(s.split(",")[1]);
        this.name=name;
        this.age=age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name+age;
    }
}
