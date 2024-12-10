package t_12_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class 知识点_6_练习 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class aClass = Class.forName("t_12_反射.Student");

        //1.获取里面所有的公共方法（包含父类中所有的公共方法）
        for (Method method : aClass.getMethods()) {
            System.out.println(method);
        }
        System.out.println("==================================");
        //2.获取包含私有方法的所有的方法对象（此时不包含父类的方法）
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        //3.获取指定的单一方法
        //要带上参数的类型
        Method m = aClass.getDeclaredMethod("setName", String.class);

        //4.获取方法的修饰符
        //5.获取方法的名字
        //6.获取方法的形参
        //7.获取方法抛出的异常

        //8.方法运行
        Student s=new Student();
        m.setAccessible(true);
        m.invoke(s,"明日香");
    }
}
