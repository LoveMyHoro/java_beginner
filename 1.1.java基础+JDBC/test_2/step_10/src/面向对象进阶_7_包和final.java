import test_5.Student;

public class 面向对象进阶_7_包和final {
    //1.什么是包：
    //（1）包就是文件夹，用来管理不同功能的java类，方便后期java的维护
    //2.包名的命名规则：
    //公司域名反写+包的作用,需要全部英文小写，见名知意。
    //eg:com.itheima.domain，使用时要使用import导入com.itheima.domain.类名。这叫做全类名(包名+类名)

    //3.使用其他类的规则（alter+回车快速导包）
    //（1）使用同一个包中的其他类时，不需要导包
    //（2）使用java.lang包中的类时，不需要导包（如String类）
    //（3）其他情况都需要导包
    //（4）如果同时使用两个包中的同名类，需要用全类名

    //4.final:
    //（1）final修饰方法：表明该方法是最终方法，不能被重写（代表一种规则）
    //（2）final修饰类：表示该类是最终类，不能被继承
    //（3）final修饰变量：该变量此时就是常量，只能被赋值一次（重点，这个常用）
    //如果final修饰的变量是引用类型，那么变量的地址值不能发生改变，对象内部的可以改变
    //（4）这里我们现在可以理解String字符串为什么是不可变的，因为字符串是被final修饰的
        public static void main(String[] args) {
            final Student s=new Student();
            s.setName("李四");//对象内部的可以改变
            //s=new Student();//报错，变量的地址值不能发生改变

    }
    //5.常量的相关知识：
    //（1）实际开发中，常量一般作为系统的配置信息，方便维护，提高可读性
    //（2）常量的命名规则：
    //单个单词：全部大写
    //多个单词：全部大写，单词之间用下划线隔开
    //例子如下





}
