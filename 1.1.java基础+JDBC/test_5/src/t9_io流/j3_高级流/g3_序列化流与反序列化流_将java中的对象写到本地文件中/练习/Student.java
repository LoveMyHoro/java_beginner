package t9_io流.j3_高级流.g3_序列化流与反序列化流_将java中的对象写到本地文件中.练习;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID=-1L;
    private String name;
    private int age;

    public Student() {
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
        return "name = " + name + ", age = " + age + "}";
    }
}
