package test_5_Object_Clone;

import java.util.Date;
import java.util.StringJoiner;

public class User implements Cloneable{

    private String name;
    private int age;
    private String address;
    private int []data;

    public User() {
    }
    public User(String name, int age, String address, int[] data) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.data = data;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override//因为重写了toString方法，可以不返回对象的地址而返回对象值
    public String toString(){
        return "角色姓名："+this.getName()+"，年龄："+this.getAge()+"，地址："+this.getAddress()+arrToString();
    }
    public String arrToString(){
        StringJoiner sb=new StringJoiner(",","[","]");
        for (int i = 0; i < data.length; i++) {
            sb.add(data[i]+"");
        }
        return sb.toString();
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        int []data=this.data;
        int []arr=new int[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i]=data[i];
        }
        User u=(User) super.clone();
        //把新的数组给拷贝的u
        u.data=arr;
        return u;
    }

}
