package t_12_反射;

import java.sql.SQLOutput;

public class 知识点_2_练习 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取class对象的三种方式
        //1.Class.forName("全类名")
        //2.类名.class
        //3.对象.getClass()

        //1.Class.forName("全类名")
        //全类名:包名+ 类名
        //最为常用
        Class aClass = Class.forName("t_12_反射.Student");
        System.out.println(aClass);

        //2.类名.class
        //一般更多的是作为参数传递
        Class bclass=Student.class;
        System.out.println(bclass);

        //3.对象.getClass()
        Student s=new Student();
        Class cclass=s.getClass();
        System.out.println(cclass);

        System.out.println(aClass==bclass);
        System.out.println(bclass==cclass);


    }
}
