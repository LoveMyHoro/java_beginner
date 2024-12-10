package t_12_反射;

import cn.hutool.script.ScriptRuntimeException;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public  String gender;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
        this.age = age;
    }
    protected Student(int age){}
    private Student(String name,int age){
        this.age=age;
        this.name=name;
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
    private void setName(String name) {
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
}
