package test_4_Object;

public class Api_Object {
    /*
    1.（1）Object 是java中的顶级父类。所有的类都直接或间接的继承Object类
      （2）Object类中的方法可以被所有子类访问
      （3）Object没有成员变量，所以只有无参构造

    2.Object中的常用方法
    （1）toString()
        核心逻辑：当我们打印一个对象时，底层会自动调用对象的toString方法，把对象变成字符串，然后打印在控制台上，打印完毕换行处理
        但是toString返回的是地址值。对于类的对象之类的如果想要看到属性值，要对其进行重写
    （2）equals():Object中equals通过比较地址值从而比较两个对象是否相等。如果想要不管地址值只比较属性值，可对equals进行重写
     比如String类继承Object的equals时就进行了重写，对属性值进行比较（但首先都要是字符串）
     注意：如果类没有对Object进行重写，默认继承比较的就是地址值

     3.具体看test中的示例



     */

}
