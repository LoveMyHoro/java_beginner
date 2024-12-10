package t9_io流.j3_高级流.g3_序列化流与反序列化流_将java中的对象写到本地文件中;

import java.io.Serial;
import java.io.Serializable;

/*
*
*（1）Serializable接口里面是没有抽象方法的，这样的接口被称作标记型接口
* 一旦实现了这个接口，那么就表示当前的Student类可以被序列化
* 理解：一个产品的合格证
*（2）Serializable会根据类的成员变量和各种方法计算出一个long类型的序列号，类一旦发生改变，序列号就会改变
* 当反序列化时的序列号与之前序列化时的序列号不一样时，就会报错
* 解决方法:定义静态序列号serialVersionUID
*（3）transient瞬态关键字：不会把被transient修饰的属性序列化到本地文件中
*
 */
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID=-1L;
    private String name;
    private int age;
    private transient String address;

    public Student() {
    }

    public Student(String name, int age,String address) {
        this.name = name;
        this.age = age;
        this.address=address;
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
        return "Student{name = " + name + ", age = " + age + "}";
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
