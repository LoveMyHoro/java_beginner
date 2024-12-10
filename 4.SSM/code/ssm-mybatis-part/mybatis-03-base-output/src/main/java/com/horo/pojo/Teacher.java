package com.horo.pojo;

/**
 * @ClassName Teacher
 * @Author iove
 * @Date 2024/10/9 下午7:45
 * @Version 1.0
 * @Description TODO 这个是非主键回显的类
 **/

public class Teacher {
    private String id;
    private String name;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher() {
    }
    public Teacher(String name){
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Teacher{id = " + id + ", name = " + name + "}";
    }
}
