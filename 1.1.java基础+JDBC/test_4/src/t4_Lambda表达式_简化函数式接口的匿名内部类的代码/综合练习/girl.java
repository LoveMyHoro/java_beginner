package t4_Lambda表达式_简化函数式接口的匿名内部类的代码.综合练习;

public class girl {
    private String name;
    private int age;
    private int height;

    public girl() {
    }

    public girl(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Girl{name='" + name + "', age=" + age + ", height=" + height + "}";
}

}
