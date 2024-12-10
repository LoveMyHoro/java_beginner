package t7_异常.练习;

import t7_异常.part_2.AgeFormatException;
import t7_异常.part_2.NameFormatException;

public class Girl {
    private String name;
    private int age;

    public Girl() {
    }

    public Girl(String name, int age) {
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
        if(name.length()<3||name.length()>10){
            throw new NameFormatException(name+"格式有误，长度应为：3-10");
        }
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
        if(age<18||age>40){
            throw new AgeFormatException(age+"不在范围内");
        }
        this.age = age;
    }

    public String toString() {
        return "Girl{name = " + name + ", age = " + age + "}";
    }
}
