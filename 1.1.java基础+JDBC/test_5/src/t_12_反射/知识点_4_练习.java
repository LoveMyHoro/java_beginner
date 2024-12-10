package t_12_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class 知识点_4_练习 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class aClass = Class.forName("t_12_反射.Student");
        //获取公共的构造方法
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("====================================");
        //获取全部的构造方法
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //获取单个的构造方法
        System.out.println("======================================");
        Constructor con = aClass.getDeclaredConstructor();
        System.out.println(con);
        //这是传入String参数的公共构造方法
        Constructor con1 = aClass.getDeclaredConstructor(String.class);
        System.out.println(con1);
        //这是传入String和int的私有构造方法
        Constructor con2 = aClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(con2);
        System.out.println("===================================");

        //获取权限修饰符
        int modifiers = con2.getModifiers();
        System.out.println(modifiers);

        //获取参数
        for (Parameter parameter : con2.getParameters()) {
            System.out.println(parameter);
        }
        System.out.println("==============================");
        //暴力反射：表示临时取消权限校验，可以利用私有的构造方法创建对象
        con2.setAccessible(true);
        Student student =(Student) con2.newInstance("明日香", 17);
        System.out.println(student);

    }
}
