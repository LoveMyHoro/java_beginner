package t_12_反射;

import java.lang.reflect.Field;

public class 知识点_5_练习 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取自解码文件
        Class aClass = Class.forName("t_12_反射.Student");

        //获取所有的成员变量
        Field[]fields=aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("============================");
        //获取单个成员变量
        Field name=aClass.getDeclaredField("name");
        System.out.println(name);

        //获取权限修饰符
        System.out.println(name.getModifiers());

        //获取成员变量的名字
        System.out.println(name.getName());

        //获取成员变量的数据类型
        System.out.println(name.getType());

        //获取成员变量记录的值
        Student s=new Student("张三",23,"男");
        name.setAccessible(true);
        String value=(String) name.get(s);
        System.out.println(value);

        //修改对象记录的值
        name.set(s,"战场原");
        System.out.println(s);



    }
}
