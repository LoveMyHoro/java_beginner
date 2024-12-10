package t10_多线程.d4_Thread常见的成员方法;

import t10_多线程.d3_多线程的实现方式.MyThread1;

public class 知识点_4_守护线程 {
    public static void main(String[] args) {
        /*
        *细节：当其他的非守护线程执行完毕后，守护线程会陆续结束（有时不会立刻结束，会执行几句）
         */
        MyThread1 t1=new MyThread1();
        MyThread2 t2=new MyThread2();
        t1.setName("女神");
        t2.setName("备胎");
        //把t2设置为守护线程
        t2.setDaemon(true);
        t1.start();
        t2.start();

    }
}
