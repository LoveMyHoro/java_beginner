package t10_多线程.d3_多线程的实现方式;

public class 知识点_1_第一种实现方式 {
    public static void main(String[] args) {
        /*
        *多线程的第一种实现方式
        *   1.自己定义一个类继承Thread线程
        *   2.重写run方法
        *   3.创建子类的对象，并启动线程
         */
        MyThread1 m1=new MyThread1();
        MyThread1 m2=new MyThread1();
        //setName和getName是MyThread1自带的方法
        m1.setName("线程1");
        m2.setName("线程2");
        //启动线程，不能直接调用run，不然就和不同的方法调用方法一样了
        m1.start();
        m2.start();
    }
}
